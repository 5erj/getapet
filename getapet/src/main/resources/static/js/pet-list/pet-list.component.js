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
				this.query = {$:''};
			
				$http.get('json/' + this.animal + 's.json').then(function(response) {
			       self.pets = response.data;
			    });
				
				this.addSearchTag = function() {
					self.query.tags = {
						$: this.tagToSearch
					};
				}
			}]
	});