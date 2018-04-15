/**
 * Created by richey on 17-7-15.
 */
angular.module("adminApp", ['emailParser'])
    .controller("MainController", ['$scope', '$interpolate', '$filter', 'EmailParser', function ($scope, $interpolate, $filter, EmailParser) {

        $scope.to = "richey@test.com";
        // $scope.emailBody = "hi,{{ to }},\n\nMy name is Richey";
        $scope.emailBody = "hi,__ to __,\n\nMy name is Richey";
        $scope.$watch('emailBody', function (body) {
            if (body) {
                // var template = $interpolate(body);
                // $scope.previewText = template({to: $scope.to});
                $scope.previewText = EmailParser.parse(body, {to: $scope.to});
            }
        });
        $scope.sayHello = $filter('lowercase')('HELLO WORLD');

    }])
