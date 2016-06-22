'use strict';

angular
	.module('petCreate')
	.component('petCreate', {
		templateUrl: 'js/pet-create/pet-create.template.html',
		controller: ['$routeParams', 'Pet',
		    function PetCreateController($routeParams, Pet) {
			 	// Parse the pet JSON from the query parameter
				this.pet = JSON.parse($routeParams.pet);
				
				var self = this;
				
				// Return whether this pet is sold
				this.isSold = function() {
					return self.pet.status.toLowerCase() === 'sold';
				}
				
				this.createPet = function() {
					var pet = new Pet(self.pet);
					
					return pet.$save(function(value, responseHeaders) {
						var petLocationURL = responseHeaders('Location');
						self.petId = petLocationURL.substring(
											petLocationURL.lastIndexOf('/') + 1);
					});
				}
			}]
	});