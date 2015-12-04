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

    $scope.verifyDuplicate = function(newCity) {
        var i;
        var isDuplicate = true;

        for(i = 0; i < $scope.cities.length; i++) {
            if($scope.cities[i].cityName = newCity) {
                isDuplicate = false;
                break;
            }
        cities[i].form.myForm.$setValidity('duplicate',!isDuplicate);
        }
    };

});

