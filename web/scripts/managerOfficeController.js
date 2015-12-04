myApp.controller('ManagerOfficeController', function ($scope, $http,  $location) {

    $http.get("/mvc/angular/flights").then(function (response) {
        $scope.flights = response.data;
    });
    $http.get("/mvc/angular/cities").then(function (response) {
        $scope.cities = response.data;
    });

    $scope.addFlight = function (flight) {
        console.log(flight);
        $http
            .post("/mvc/angular/flights/add",
                {
                    city: $scope.flight.city.cityName,
                    seatCount : $scope.flight.seatCount,
                    departureDate : $scope.flight.departureDate
                })
            .then(function (response) {
                updateFlights();
            });
    };

    var updateFlights = function () {
        $http
            .get("/mvc/angular/flights")
            .then(function (response) {
                $scope.cities = response.data;
            });
    };

});
