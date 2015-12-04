myApp.controller('CityController', function ($scope, $http,  $location) {

    $http.get("/mvc/angular/flights").then(function (response) {
        $scope.flights = response.data;
    });
    $http.get("/mvc/angular/cities").then(function (response) {
        $scope.cities = response.data;
    });

    $scope.addCity = function (city) {
        $http
            .post("/mvc/angular/cities/add", city)
            .then(function (response) {
                updateCities();
            });
    };

    var updateCities = function () {
        $http
            .get("/mvc/angular/cities")
            .then(function (response) {
                $scope.cities = response.data;
            });
    };

    $scope.deleteCity = function (city) {
        $http
            .delete("/mvc/angular/cities/delete/" + city)
            .then(function (response) {
                updateCities();
            });
    };

});

