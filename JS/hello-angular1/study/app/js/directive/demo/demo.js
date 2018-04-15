define(["main-app"],function (app) {
    app.directive("demoDirective",function () {
        return{
            restrict:"E",
            template:"<div>this is a demo directive</div>"
        }
    })
})