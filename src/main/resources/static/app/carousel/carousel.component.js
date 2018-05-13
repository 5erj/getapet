'use strict';

angular
	.module('carousel')
	.component('carousel', {
		templateUrl: 'app/carousel/carousel.template.html',
		controller: function CarouselController($location) {
			 this.myInterval = 5000;
			 this.noWrapSlides = false;
			 this.active = 0;
			 this.slides = [];
			 
			 this.slides.push({
			      image: 'app/img/carousel/dog.png',
			      link: '/dogs',
			      id: 0
			    });
			 this.slides.push({
			      image: 'app/img/carousel/cat.png',
			      link: '/cats',
			      id: 1
			    });
			 this.slides.push({
			      image: 'app/img/carousel/bird.png',
			      link: '/birds',
			      id: 2
			    });
			 
			 var self = this;
			 this.navigate = function(slideId) {
				$location.url(self.slides[slideId].link);
			 }
		}
	});