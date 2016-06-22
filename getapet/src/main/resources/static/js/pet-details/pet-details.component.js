'use strict';

angular
	.module('petDetails')
	.component('petDetails', {
		templateUrl: 'js/pet-details/pet-details.template.html',
		controller: ['$routeParams', '$http', 'Pet',
		    function PetDetailsController($routeParams, $http, Pet) {
			 	// Parse the pet JSON from the query parameter
				this.pet = JSON.parse($routeParams.pet);
				
				var self = this;
				
				// Return whether this pet is sold
				this.isSold = function() {
					return self.pet.status.toLowerCase() === 'sold';
				}
				
				this.createPet = function() {
					var pet = new Pet({
						"name": "Max",
						"photoUrls": [
							'http://localhost:8080/img/beagle.jpg'
						]
					});
					
					return pet.$save(function(value, responseHeaders) {
						console.log(value);
					});
				}
			}]
	});