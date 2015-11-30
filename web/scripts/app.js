var myApp = angular.module('myApp', []);


myApp.controller('firstCtrl', function ($scope, $http) {

    $http.get('/mvc/api/').then(function (response) {
        $scope.arr = response.data;

    });
    $http.get('/mvc/api/cities').then(function (response) {
        $scope.cities = response.data;
    })

    $http.get('/mvc/api/flights').then(function (response) {
        $scope.flights = response.data;
    })

})