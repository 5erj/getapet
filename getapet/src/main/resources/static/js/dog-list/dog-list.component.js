'use strict';

angular
	.module('dogList')
	.component('dogList', {
		templateUrl: 'js/dog-list/dog-list.template.html',
		controller: function DogListController() {
			this.dogs = [
	             {
	            	 name: 'max',
	            	 status: 'available'
	             }, {
	            	 name: 'buddy',
	            	 status: 'available'
	             }, {
	            	 name: 'charlie',
	            	 status: 'sold'
	             }
	         ];
		}
	});