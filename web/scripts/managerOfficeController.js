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
            .post("/mvc/angular/flights/add", flight.cityName, flight.seatCount, flight.departureDate)
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
