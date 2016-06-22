angular.
  module('getapetApp').
  config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/', {
        	template: '<div class="arrow-left"></div>' +
        				'<img src="img/dog-banner.png"/>' +
        				'<div class="arrow-right"></div>'
        }).
        when('/my-pets', {
            template: '<pet-retrieve></pet-retrieve>'
          }).
        when('/dogs', {
            template: '<pet-list animal="dog"></pet-list>'
          }).
          when('/create', {
              template: '<pet-create></pet-create>'
            }).
        otherwise('/');
    }
  ]);