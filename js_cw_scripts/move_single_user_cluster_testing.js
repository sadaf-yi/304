var fs = require('fs');
var request = require('request');
var configFile = ('config.json');
var _ = require('underscore');
var cw = require('./cw');
var password = "command604";

var initLat = 49.279
var initLon = -123.147



// Helper Functions

var processUnit = function(unit) {
      if (unit != undefined) {
      return postPosition(unit, initLat, initLon, new Date());
    } else {
      if (config.cw.createNewUsers) {
        createUnit(unit.callsign, function(err, unit) {
          if (err) {
            console.log('Unable to post position for unmatched unit ' + callsign + ', error creating unit');
            return;
          }
          return postPosition(unit, initLat, initLon, new Date());
        });
      }
    }
  }


var userCallsignFromUsername = function(user) {
  return user.username.split('@')[0].toUpperCase();
};

var loginUnit = function(unit, callback) { // (element, index, list)
  console.log('Attempting to log in ' + unit.username);
  cw.login( { username: unit.username, password: unit.password, from_communicator: true, device_type: "android", channel_id: unit.callsign }, function(err, response, token) {
    if (err || (response.statusCode != 200)) {
      console.log('Error logging in unit ' + unit.callsign + ': ' + err);
      err = err || true;    var callsign = data.sourceAddress,
              latitude = data.latitude,
              longitude = data.longitude;
    } else {
      unit.token = token;
      unit.loginResponseCode = response.statusCode;
      console.log('Successfully logged in ' + unit.callsign + " Status Code: " + unit.loginResponseCode);
    }
    if (callback) return callback(err);
  });
}

// Given a unit, lat, long, and time
// creates a position,
// in original app, only called in processPacket

var postPosition = function(unit, latitude, longitude, time) {
  var position = {
    latitude: latitude,
    longitude: longitude,
    recorded_at: config.cw.overrideTimestamp ? new Date() : time.toISOString()
  }

  var postCallback = function(err, response) {
    if (response.statusCode != 201 ) {
      console.log('Error posting position for unit ' + unit.callsign + ': ' + response.statusCode + " : " + response.statusMessage);
    } else {
      // woooo
      console.log('Successfully posted position for unit ' + unit.callsign + ': ' + JSON.stringify(position) + " " + response.statusCode + " : " + response.statusMessage);
      unit.positionHasBeenSet = true;
      moveUnit();
    }
  };

  if (! unit.token) {
    loginUnit(unit, function(err) {
      if (!err) {
        console.log("Creating Position with - Callsign: " + unit.callsign + ", Token: " + unit.token);
        cw.createPosition(unit, position, postCallback);
      }
    });
  } else {
    console.log("Creating Position with - Callsign: " + unit.callsign + ", Token: " + unit.token);
    cw.createPosition(unit, position, postCallback);
  }
}

// Given a callsign and a callback function, create a unit
// Perhaps callback function should be post Position??
// In original app, callback is an anonymous function that handles error text
// In original app, createUnit is only used within processPacket
var createUnit = function(callsign, callback) {
  console.log('Attempting to create new unit: ' + callsign);

  var user = {
    email: callsign.toLowerCase() + '@cwtest.com',
    username: callsign.toLowerCase() + '@cwtest.com',
    name: callsign,
    password: password,
    password_confirmation: password,
    role: 'agent', // later: responder
    initial: callsign,
    rank: '',
    color: '#ffffff',
    text_color: '#000000',
    archived: false,
    admin: false,
    organization_id: config.cw.organizationId, // gets validated server-side but we have to populate it
    permission_ids: [],
    group_ids: []
  };

  cw.createUser(config.cw.authToken, user, function(err, response, body) {
    if (err || (response.statusCode >= 400)) {
      return callback('Error creating user: ' + response.statusCode);
    }

    var unitConfig = {
      callsign: user.name,
      username: user.username,
      password: password,
      user: user
    };
    config.cw.units.push(unitConfig);

    console.log('Successfully created unit: ' + unitConfig.callsign);
    return callback(null, unitConfig);
  });
}




// After initializing users/units, move them out and in to cluster
// Function to move the first user in the array of units out of the cluster and back in
var moveUnit = function() {
  var allUnitsPostedPositions = false
    for (var i = 0; i < config.cw.units.length; i++){
      var currentUnitToCheck = config.cw.units[i];
        if (!currentUnitToCheck.positionHasBeenSet){
          allUnitsPostedPositions = false;
          return;
        } else allUnitsPostedPositions = true;
      }

    if (allUnitsPostedPositions){
      var unitToMove = config.cw.units[0];
      var lat = initLat;
      var long = initLon;
      var currentRightInterval = 1;
      var currentLeftInterval = 1;
    var moveOut = function() {
      var positionToMoveTo = {
        latitude: lat,
        longitude: long,
        recorded_at: config.cw.overrideTimestamp ? new Date() : time.toISOString()
      }
      console.log("moving " + unitToMove.callsign + " to " + JSON.stringify(positionToMoveTo));
      cw.createPosition(unitToMove, positionToMoveTo, null);
      var incrementRight = setTimeout(function() {
        if (currentRightInterval < 10) {
        currentRightInterval += 1;
        long += 0.005;
        moveOut();
      }
    incrementLeft}, 12000);
      var incrementLeft = setTimeout(function() {
        if (currentRightInterval === 10) {
          if (currentLeftInterval < 10){
            currentLeftInterval += 1;
            long -= 0.005;
            moveOut();
          }}}, 12000);
      incrementRight;
    };
  }
    setTimeout(moveOut(), 12000);
};

//
// // var moveIn = function() {
// //   post Position(unitToMove, config.filter.point.latitude, long, new Date())
// //   long = long - 1;
// //   if (currentInterval < 10) {
// //     currentInterval += 1;
// //     setTimeout(moveIn, 10000);
//   setTimeout(moveIn, 10000);

// Test Config Method. Should use the 5 users that are already created
// User callsigns are listed in config.json
// After creating unit for each created unit, post locations for each
var config = JSON.parse(fs.readFileSync(configFile));
config.cw.units = [];
cw.config(config.cw.server);

var testConfig = function() {
  if (!fs.existsSync(configFile)) {
    console.error('Config file ' + configFile + ' doesn\'t exist, exiting.');
    return;
  }

  cw.login({username:config.cw.username, password:config.cw.password}, function(err, response, token, organization_id) {
    if (err) {
      console.log('Error logging in admin user, check that credentials in config.json are correct');
      return;
    }
    console.log('Successfully logged in admin user');

    config.cw.authToken = token;
    config.cw.organizationId = organization_id;

    // fetch user list now
    cw.getUsers(config.cw.authToken, function(err, response, body) {
      if (err) {
        console.log('Error fetching user list: ' + err);
      } else {
        var users = JSON.parse(body).users;
        _.each(users, function(user, index, list) {

          // Only change passwords for our APRS users
          if (user.role !== 'agent') return; // TBD - change to responder
          if (config.filter.callsigns.indexOf(userCallsignFromUsername(user)) == -1) return; // only change if they're on the filter list

          //check to make sure the org id is being assigned correctly
          user.callsign = userCallsignFromUsername(user);
          user.organization_id = organization_id;

          console.log('Processing user: ' + user.username);
          var currentUnit = {
              callsign: user.callsign, // don't use initial because I'm overloading it!
              username: user.username,
              password: password,
              user: user
            };
          config.cw.units.push(currentUnit);
          console.log('Successfully created unit for ' + user.username +
              ', and added unit to array');
          console.log('Logging in unit ' + currentUnit.callsign);

          setTimeout(loginUnit(currentUnit, function(err) {
            if (!err) {
              console.log("Logged in unit " + currentUnit.callsign + " - Login token: " + currentUnit.token);
              processUnit(currentUnit);
            } else {
              console.log(err);
            }}), 5000);
          })
        }})
      })}


  // Function to start moving units and posting their positions
  var postAndMoveUnits = function(){
    for (var i = 0; i < config.cw.units.length; i++) {
      var unit = config.cw.units[i];
      postPosition(unit);
    }
    moveUnit();
  };

  testConfig();

  module.exports.processUnit = processUnit;
  module.exports.testConfig = testConfig;
