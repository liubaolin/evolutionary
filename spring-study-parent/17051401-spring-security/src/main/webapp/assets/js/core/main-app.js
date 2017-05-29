"use strict";
define(["angular", "jquery"], function (angular, $) {
    var app = angular.module("security-demo", []);
    app.controller("IndexMain", ["$scope", "$rootScope",
        function ($scope, $rootScope) {

        }
    ]);

  

    app.run(["$rootScope", "$timeout", function ($rootScope) {

    }]);

    //模块开发不要使用以下方法
    app.get = function (ngObject) {
      
    };
    app.invoke = function (ngFunction) {

    };


    /**
     * 为避免缓存数据被用户删除后导致filter出错 使用这个filter做一层转换 如果不存在不会出错
     */
    app.filter("SafeGetFilter", function () {

    });
    return app;
});