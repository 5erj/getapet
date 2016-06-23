'use strict';

angular
	.module('petDetails')
	.component('petDetails', {
		bindings: {
			serializedpet: '@'
		},
		templateUrl: 'app/pet-details/pet-details.template.html',
		controller: function PetDetailsController() {
			var self = this;
			this.pet = JSON.parse(this.serializedpet);
		}
	});