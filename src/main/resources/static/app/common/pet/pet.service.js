angular.module('pet')
	.factory('Pet', ['$resource', 
	     function ($resource) {
			return $resource('/pet/:petId');
		}
	]);