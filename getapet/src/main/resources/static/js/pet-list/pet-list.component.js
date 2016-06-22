'use strict';

angular
	.module('petList')
	.component('petList', {
		bindings: {
			animal: '@'
		},
		templateUrl: 'js/pet-list/pet-list.template.html',
		controller: ['$http', 
		    function DogListController($http) {
				var self = this;
				// Initialize the query filter to match anything
				this.query = {$:''};
			
				$http.get('json/' + this.animal + 's.json').then(function(response) {
			       self.pets = response.data;
			    });
				
				// Adds the tag to search on to the query filter
				this.addSearchTag = function() {
					self.query.tags = {
						$: this.tagToSearch
					};
				}
			}]
	});