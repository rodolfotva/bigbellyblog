angular.module('main').directive('postPage', function () {
	return {
        templateUrl: 'post',
		restrict: 'AE',
		controller: 'mainController',
		link: function($scope, $element, $attrs, ctrl){
			$scope.fetchHomePost();
		}
    };
});

angular.module('main').directive('donationPage', function () {
    return {
        templateUrl: 'donation'
    };
});
