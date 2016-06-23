'use strict';

angular
	.module('carousel')
	.component('carousel', {
		templateUrl: 'app/carousel/carousel.template.html',
		controller: function CarouselController() {
			 this.myInterval = 5000;
			 this.noWrapSlides = false;
			 this.active = 0;
			 this.slides = [];
			 
			 this.slides.push({
			      image: 'app/img/carousel/dog.png',
			      id: 0
			    });
			 this.slides.push({
			      image: 'app/img/carousel/cat.png',
			      id: 1
			    });
			 this.slides.push({
			      image: 'app/img/carousel/bird.png',
			      id: 2
			    });
		}
	});