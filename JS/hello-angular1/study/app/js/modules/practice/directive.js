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
        $scope.someProperty = "some property";
        $scope.someObj = {otherProperty: "other Property"};
    })
    .controller("ChildController", function ($scope) {
        $scope.chileProperty = 'child scope';
        $scope.fullSentenceFromChild = 'Same $scope:We can access: '
            + $scope.rootProperty + ' and '
            + $scope.parentProperty + ' and '
            + $scope.chileProperty;
    })
    .controller("ScopeController", function ($scope) {
        $scope.name = "ParentScope";
        $scope.age = "20";
        $scope.changeMyAge = function () {
            $scope.age = 22;
        }

    })
    .controller("DirectiveController", function ($scope) {

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
    //单向的数据传递
    .directive("myDirectiveAttr", function () {
        return {
            restrict: 'A',
            replace: true,
            /**
             * 隔离作用域,本质上意味着指令有了一个只属于它自己的$scope对象,这个对象只能在指令的方法中或指令的模板字符串中使用
             * 不能在隔离作用域对象内部直接设置属性的值,
             *
             */
            scope: {
                myUrl: '@',
                myLinkText: '@',
                // someProperty: 'needs to be set' //这样是不对的,不能直接在隔离作用域中为属性设值
                someProperty: '@',
                someProperty2: '@someAttr' //默认情况西下someProperty2在DOM中映射的是some-property2属性,这里显式修改为映射some-attr属性

            },
            //在指令的模板字符串中使用隔离作用域对象($scope)的属性
            template: '<a href="{{myUrl}}">{{myLinkText}} someProperty: {{someProperty}} someProperty2: {{someProperty2}} someProperty3:{{someProperty3}}</a> ',
            //指令可以有自己的控制器
            controller: function ($scope) {
                $scope.someProperty3 = "some property with Controller";
            }

        }
    })
    //双向数据绑定
    .directive("myDirectiveBothway", function () {
        return {
            restrict: 'A',
            replace: true,
            scope: {
                myUrl: '=someAttr', //双向数据绑定
                myLinktext: '@'
            },
            template: '\
            <div>\
                <label>My Url Field:</label>\
                <input type="text" ng-model="myUrl"/>\
                <a href="{{myUrl}}">{{myLinktext}}</a>\
             </div>'
        };
    })
    //指令作用域 scope:false
    .directive("scopeFalseDirective", function () {
        return {
            restrict: 'AE',
            replace: true,
            scope: false,//默认是false，指令模板中可以直接使用父作用域中的变量，函数
            template: "<div> " +
            "<h3>下面是指令生成的内容：</h3>" +
            "我的名字是：<span ng-bind='name'></span><br/>" +
            "我的年龄是：<span ng-bind='age'></span>" +
            "<input type='text' ng-model='name'/>" +
            "</div>"
        }
    })
    //指令作用域 scope:true
    .directive("scopeTrueDirective", function () {
        return {
            restrict: 'AE',
            replace: true,
            scope: true,//这表明我们创建的指令要创建一个新的作用域，这个作用域继承自我们的父作用域
            template: "<div> " +
            "<h3>下面是指令生成的内容：</h3>" +
            "我的名字是：<span ng-bind='name'></span><br/>" +
            "我的年龄是：<span ng-bind='age'></span>" +
            "<input type='text' ng-model='name'/>" +
            "</div>"
        }
    })
    //指令作用域 scope:{}  隔离作用域
    .directive("scopeObjDirective", function () {
        return {
            restrict: 'AE',
            replace: true,
            scope: {//scope设置为{}时，意味着我们创建的一个新的与父作用域隔离的新的作用域
                name: '@myName',
                age: '=',
                changeAge: '&changeMyAge'
            },
            template: "<div> " +
            "<h3>下面是指令生成的内容：</h3>" +
            "我的名字是：<span ng-bind='name'></span><br/>" +
            "我的年龄是：<span ng-bind='age'></span>" +
            "这里修改我的名字：<input type='text' ng-model='name'/><br/>" +
            "<button ng-click='changeAge()'>修改年龄</button>" +
            "</div>"
        };
    })
    .directive("sidebox", function () {
        return {
            restrict: 'AE',
            scope: {
                title: '@'
            },
            transclude: true,
            template: '<div class="sidebox">\
                        <div class="content">\
                            <h2 class="header">{{title}}</h2>\
                            <span class="content" ng-transclude></span>\
                        </div>\
            </div>'
        };
    })
    .directive("requireNgModelController", function () {
        return {
            require: '?ngModel',
            link: function (scope, ele, attrs, ngModel) {
                if (!ngModel) {
                    return;
                }
                // 现在我们的指令中已经有ngModelController的一个实例
            }
        }
    })
    /**
     * 为了设置作用域中的视图值,需要调用 ngModel.$setViewValue() 函数
     * $setViewValue()方法适合于在自定义指令中监听自定义事件
     * 单独调用$setViewValue()不会唤起一个新的digest循环,因此如果想更新指令,需要在设置$viewValue后手动触发digest。
     */
    .directive("setViewValueController", function () {
        return {
            require: '?ngModel',
            link: function (scope, ele, attrs, ngModel) {
                if (!ngModel) {
                    return;
                }
                $(function () {
                    ele.datepicker({
                        onSelect: function (data) {
                            scope.$apply(function () {
                                ngModel.$setViewValue(date);
                            })
                        }
                    })
                })

            }
        };
    })
    .directive("validationExample", function () {
        return {
            require: 'ngModel',
            link: function (scope, ele, attrs, c) {
                scope.$watch(attrs.ngModel, function () {
                    $http({
                        method: 'POST',
                        url: '/api/check/' + attrs.ensureUnique,
                        data: {field: attrs.ensureUnique, valud: scope.ngModel}
                    }).then(
                        function (data, status, headers, cfg) {
                            c.$setValidity('unique', data.isUnique);
                        },
                        function (data, status, headers, cfg) {
                            c.$setValidity('unique', false);
                        }
                    )

                });
            }
        }
    })
    //自定义验证
    .directive('oneToTen', function () {
        return {
            require: '?ngModel',
            link: function (scope, ele, attrs, ngModel) {
                if (!ngModel) return;
                ngModel.$parsers.unshift(
                    function (viewValue) {
                        var i = parseInt(viewValue);
                        if (i >= 0 && i < 10) {
                            ngModel.$setValidity('oneToTen', true);
                            return viewValue;
                        } else {
                            ngModel.$setValidity('oneToTen', false);
                            return undefined;
                        }
                    }
                )
            }
        }
    })
    .directive("oneToTen",function () {
        return {
            return:'?ngModel',
            link:function (scope,ele,attrs,ngModel) {
                if(!ngModel) {
                    return;
                }
                ngModel.$formatters.unshift(function (v) {
                    return $filter('number')(v);
                })

            }

        };
        
    })

;