angular.
  module('getapetApp').
  config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/dogs', {
          template: '<dog-list></dog-list>'
        }).
        when('/', {
        	template: '<div class="arrow-left"></div>' +
        				'<img src="img/dog-banner.png"/>' +
        				'<div class="arrow-right"></div>'
        }).
        otherwise('/');
    }
  ]);