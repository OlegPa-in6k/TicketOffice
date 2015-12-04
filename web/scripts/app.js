var myApp = angular.module('myApp', ['ngRoute' ]);

myApp.config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/views/main.html'
            })
            .when('/TicketOffice', {
                templateUrl: '/views/ticketOffice.html',
                controller: 'TicketOfficeController'
            })
            .when('/ManagerOffice', {
                templateUrl: '/views/managerOffice.html',
                controller: 'ManagerOfficeController'
            })
            .when('/Cities', {
                templateUrl: '/views/cities.html',
                controller: 'CityController'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
