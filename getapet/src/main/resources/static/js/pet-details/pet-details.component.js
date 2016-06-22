'use strict';

angular
	.module('petDetails')
	.component('petDetails', {
		templateUrl: 'js/pet-details/pet-details.template.html',
		controller: ['$routeParams', '$http', 
		    function PetDetailsController($routeParams, $http) {
			 	// Parse the pet JSON from the query parameter
				this.pet = JSON.parse($routeParams.pet);
				
				var self = this;
				
				// Return whether this pet is sold
				this.isSold = function() {
					return self.pet.status.toLowerCase() === 'sold';
				}
			}]
	});