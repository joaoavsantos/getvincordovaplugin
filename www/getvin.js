var exec = require('cordova/exec');

var PLUGIN_NAME = 'getvincordovaplugin';

exports.getVin = function (success, error) {
  exec(success, error, PLUGIN_NAME, "getVin", []);
};
