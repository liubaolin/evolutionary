/**
 * Created by richey on 17-7-15.
 */
angular.module("emailParser", [])
    .config(['$interpolateProvider',function ($interpolateProvider) {
        $interpolateProvider.startSymbol('__');
        $interpolateProvider.endSymbol('__');
    }])
    .factory('EmailParser',['$interpolate',function ($interpolate) {
        return {
            parse: function (text, context) {
                var template = $interpolate(text);
                return template(context);
            }
        };
    }])