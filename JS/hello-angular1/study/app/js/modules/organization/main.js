/**
 * Created by richey on 17-8-24.
 */
require.config({
    paths: {
        "jquery": "../../../../bower_components/jquery/dist/jquery",
        "main-app":"../../main-app",
        "angular":"../../../../bower_components/angular/angular",
        "common-module":"../../common-module",
        "orgchart":"../../../../bower_components/orgchart/dist/js/jquery.orgchart",
        "html2canvas":"../../../../bower_components/html2canvas/build/html2canvas",
        "richey-orgchart":"../../directive/richey-orgchart/richey-orgchart"
    },
    shim:{
        "angular":{
            deps:["jquery"],
            exports:"angular"
        },
        "orgchart":{
            deps:["jquery","html2canvas"],
            exports:"orgchart"
        }
    }

});
require(["angular","main-module"], function (angular){
    angular.bootstrap(document, ["demoApp"]);
});