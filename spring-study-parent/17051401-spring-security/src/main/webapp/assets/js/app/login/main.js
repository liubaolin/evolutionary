"use strict";
requirejs.config({
  //By default load any module IDs from ../../core
  paths: {
    "angular": '../../core/angular',
    "jquery":'../../core/jquery',
    "main-app": "../../core/main-app",
  },
  shim: {
    "angular": {
      deps: ["jquery"],
      exports: "angular"
    },
  }
});

// Start the main app logic.
require(['angular','main-module'], function (angular) {
  angular.bootstrap(document, ["security-demo"]);
});