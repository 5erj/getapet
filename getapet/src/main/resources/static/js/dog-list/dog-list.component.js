'use strict';

angular
	.module('dogList')
	.component('dogList', {
		templateUrl: 'js/dog-list/dog-list.template.html',
		controller: ['$http', 
		    function DogListController($http) {
				var self = this;
			
				$http.get('json/dogs.json').then(function(response) {
			       self.dogs = response.data;
			    });
			}]
	});