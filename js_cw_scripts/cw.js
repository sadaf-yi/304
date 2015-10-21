var request = require('request');

function cw() {
  this.server = 'https://cw-staging-1.herokuapp.com';
  return this;
}

cw.config = function(server) {
  this.server = server || this.server;
};

// callback params are (error, token)
cw.login = function(params, callback) {
  var postData = JSON.stringify(
    {
      username: params.username,
      password: params.password,
      from_communicator: params.from_communicator || false,
      channel_id: params.channel_id,
      device_type: params.device_type
    });

  request({
    url: this.server + '/api/tokens',
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: postData //Set the body as a string
  }, function(error, response, body){
    if (response.statusCode === 403){
      return callback(error, response, token, organization_id);
    }
    var parsed = JSON.parse(body);
    var token = body ? parsed.token : undefined;
    if (parsed.user === undefined){
      var organization_id = parsed.config.user.organization_id;
    } else {
      var organization_id = parsed.user.organization_id;
    };
    return callback(error, response, token, organization_id);
  });
};

cw.getUsers = function(token, callback) {
  request({
    url: this.server + '/api/users',
    method: 'GET',
    headers: { 'Authorization': 'Token token=' + token }},
    callback
  );
};

cw.createUser = function(token, user, callback) {
  var postUser = { user: user }; // thanks rails
  request({
    url: this.server + '/api/users',
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Token token=' + token },
    body: JSON.stringify(postUser)},
    callback
  );
}

cw.patchUser = function(token, id, patch, callback) {
  var user = { user: patch }
  request({
    url: this.server + '/api/users/' + id,
    method: 'PATCH',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Token token=' + token },
    body: JSON.stringify(user)},
    callback
  );
};

// TBD - there appears to be a bug in the API where if you change the password,
// it won't take it you update the entire record (or possibly any other params)

// callback params are (error)
cw.createPosition = function(unit, position, callback) {
  console.log("Within createPosition, unit: " + unit.callsign + ", unit token: " + unit.token)
  request({
    url: this.server + '/api/positions',
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Token token=' + unit.token
    },
    body: JSON.stringify(position) //Set the body as a string
  }, function(err, response, body) {
    if (callback) return callback(err, response);
  });
};



module.exports = cw;
