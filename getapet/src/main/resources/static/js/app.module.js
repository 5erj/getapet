'use strict';

//Main app module
angular
	.module('getapetApp', [
       // dependencies
       'ngAnimate',
       'ngRoute',
       'ui.bootstrap',
	   'petList',
	   'petDetails',
	   'petRetrieve'
    ]);