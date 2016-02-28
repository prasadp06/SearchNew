var app = angular.module('schedulerApp', ['ngRoute']);
app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        controller: 'LoginController',
        templateUrl: 'views/login.html'
    })
    .when('/jobs/', {
        controller: 'JobController',
        templateUrl: 'views/jobs.html'      
    })
    .otherwise ({redirectTo: '/' });
    
});
