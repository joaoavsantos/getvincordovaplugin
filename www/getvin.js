var exec = require('cordova/exec');

var PLUGIN_NAME = 'GetVinPlugin';

exports.getVin = function (success, error) {
  exec(success, error, PLUGIN_NAME, "getVin", []);
};
