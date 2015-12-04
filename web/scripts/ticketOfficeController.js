myApp.controller('TicketOfficeController', function ($scope, $http,  $location) {

    $http.get("/mvc/angular/flights").then(function (response) {
        $scope.flights = response.data;
    });
    $http.get("/mvc/angular/cities").then(function (response) {
        $scope.cities = response.data;
    });

});