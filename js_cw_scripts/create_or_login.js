var fs = require('fs');
var request = require('request');
var _ = require('underscore');
var cw = require('./cw.js');

var loginUnit = function(unit, callback) { // (element, index, list)
  console.log('Attempting to log in ' + unit.username);
  cw.login( { username: unit.username, password: unit.password, from_communicator: true, device_type: "android", channel_id: unit.callsign }, function(err, response, token) {
    if (err || (response.statusCode != 200)) {
      console.log('Error logging in unit ' + unit.callsign + ': ' + err);
    } else {
      unit.token = token;
      unit.loginResponseCode = response.statusCode;
      console.log('Successfully logged in ' + unit.callsign + " Status Code: " + unit.loginResponseCode);
    }
    if (callback) return callback(err);
  });
}
