/**
 * Created by richey on 17-8-9.
 */
angular.module("configAndRunA;;", [])
    .config(function ($provide,$compileProvider) {
        $provide.factory('myFactory',function () {
            var service = {};
            return service;
        });
        $compileProvider.directive('myDirective',function () {
           return{
               template:'<button>Click me</button>'
           }
        });

    })
    .config(function ($routeProvider) {
        $routeProvider.when('/', {
            controller: 'WelcomeController',
            template: 'views/welcome.html'
        });
    })
    .config(function (ConnectionProvider) {
        ConnectionProvider.setApiKey('SOME_API_KEY');
    })

    .run(function ($rootScope,AuthService) {
        $rootScope.$on('$rootChangeStart',function (evt,next,current) {
            if(!AuthService.userLoggedIn()) {
                if(next.templateUrl === 'Login.html'){
                    //已经转向登陆路由，因此无需重定向
                }else{
                    $location.path('/login');
                }
            }
        })
    })
;