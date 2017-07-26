/**
 * Created by richey on 17-7-26.
 */
angular.module("myDirectiveApp", [])
    .run(function ($rootScope) {
        //使用run访问$rootScope
        $rootScope.rootProperty = 'root scope';
    })
    .controller("ParentController", function ($scope) {
        //使用.controller访问‘ng-controller’内部的属性
        $scope.parentProperty = 'parent scope';
    })
    .controller("ChildController", function ($scope) {
        $scope.chileProperty = 'child scope';
        $scope.fullSentenceFromChild = 'Same $scope:We can access: '
            + $scope.rootProperty + ' and '
            + $scope.parentProperty + ' and '
            + $scope.chileProperty;
    })
    .directive("myDirective", function () {
        return {
            restrict: 'E',
            template: '<a href="http://google.com">Click me to go to Google</a>'
        };
    })
    .directive("myDirectiveReplace", function () {
        return {
            restrict: 'E',
            replace: true,  //将自定义标签从DOM中完全移除掉
            template: '<a href="http://google.com">Click me to go to Google</a>'
        };
    })

;sss