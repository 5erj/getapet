'use strict';

angular
	.module('petRetrieve')
	.component('petRetrieve', {
		templateUrl: 'js/pet-retrieve/pet-retrieve.template.html',
		controller: ['Pet', 
		    function PetRetrieveController(Pet) {
				var self = this;
				
				self.retrievePet = function() {
					return Pet.get({petId: self.petId}, 
							function(value, responseHeaders) {
						self.pet = value;
					})
				}
				
			}]
	});