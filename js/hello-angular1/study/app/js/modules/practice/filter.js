/**
 * Created by richey on 17-7-16.
 */
angular.module("filterPractice", [])
    .controller("FilterController", function ($scope) {
        $scope.peoples = [
            {
                name: 'richey',
                age: 18
            }, {
                name: 'angular',
                age: 2
            }, {
                name: 'java',
                age: 8
            }
        ];
        $scope.ordersFunc = function (person) {
            return person.age;
        }

    })
    .filter('capitalize', function () {
        return function (input) {
            if (input) {
                return input[0].toUpperCase() + input.slice(1);
            }
        }
    });
