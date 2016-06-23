'use strict';

angular
	.module('petRetrieve')
	.component('petRetrieve', {
		templateUrl: 'app/pet-retrieve/pet-retrieve.template.html',
		controller: ['Pet', 
		    function PetRetrieveController(Pet) {
				// Flag to control the message that needs to be 
				// displayed on pet deletion
				this.deletedPet = false;
				
				var self = this;
				
				self.retrievePet = function() {
					return Pet.get({petId: self.petId}, 
							function(value, responseHeaders) {
						self.pet = value;
						self.deletedPet = false;
					})
				}
				
				self.deletePet = function() {
					return Pet.delete({petId: self.petId}, 
							function(value, responseHeaders) {
						console.log('pet removed');
						self.pet = null;
						self.deletedPet = true;
					})
				}
			}]
	});