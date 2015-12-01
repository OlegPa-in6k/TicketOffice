var myApp = angular.module('myApp', []);


myApp.controller('MainController', function ($scope, $http) {

    $http.get("/mvc/angular/cities").then(function (response) {
        $scope.cities = response.data;
    });

    $http.get("/mvc/angular/flights").then(function (response) {
        $scope.flights = response.data;
    });

    $scope.addCity = function(city) {
        $http
            .post("/mvc/angular/cities/add", {name : city.cityName})
            .then(function (response) {
                updateCities();
            });
    };

    //$scope.deleteCity = function (city) {
    //    $http
    //        .delete("/mvc/angular/cities/delete" , city)
    //        .then(function (response) {
    //            updateCities();
    //        });
    //};

    var updateCities = function () {
        $http
            .get("/mvc/angular/cities")
            .then(function (response) {
                $scope.cities = response.data;
            });
    };


});