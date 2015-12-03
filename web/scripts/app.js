var myApp = angular.module('myApp', ['ngRoute' ]);

myApp.config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/views/main.html'
            })
            .when('/TicketOffice', {
                templateUrl: '/views/ticketOffice.html',
                controller: 'MainController'
            })
            .when('/ManagerOffice', {
                templateUrl: '/views/managerOffice.html',
                controller: 'MainController'
            })
            .when('/Cities', {
                templateUrl: '/views/cities.html',
                controller: 'MainController'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
