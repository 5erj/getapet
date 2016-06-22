'use strict';

angular
	.module('petDetails')
	.component('petDetails', {
		bindings: {
			serializedpet: '@'
		},
		templateUrl: 'js/pet-details/pet-details.template.html',
		controller: function PetDetailsController() {
			var self = this;
			this.pet = JSON.parse(this.serializedpet);
		}
	});