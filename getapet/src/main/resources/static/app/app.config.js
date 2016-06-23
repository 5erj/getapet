angular.
  module('getapetApp').
  config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/', {
        	template: '<carousel></carousel'
        }).
        when('/my-pets', {
            template: '<pet-retrieve></pet-retrieve>'
        }).
        when('/dogs', {
            template: '<pet-list animal="dog"></pet-list>'
        }).
        when('/cats', {
        	template: '<pet-list animal="cat"></pet-list>'
        }).
        when('/birds', {
            template: '<pet-list animal="bird"></pet-list>'
        }).
        when('/create', {
        	template: '<pet-create></pet-create>'
        }).
        otherwise('/');
    }
  ]);