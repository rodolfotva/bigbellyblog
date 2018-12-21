angular.module('main').directive('postPage', function () {
	return {
        templateUrl: 'post',
		restrict: 'AE',
		controller: 'mainController',
		link: function($scope, $element, $attrs, ctrl){
			$scope.fetchHomePost();
			
		    $scope.showPostContent = function(post) {
		    	$scope.postMain = post; 
		    	$scope.$apply;
		    };
		}
    };
});

angular.module('main').directive('donationPage', function () {
    return {
        templateUrl: 'donation'
    };
});

angular.module('main').directive('listPage', function () {
    return {
        templateUrl: 'list',
		restrict: 'AE',
		controller: 'mainController',
		link: function($scope, $element, $attrs, ctrl){
			$scope.fetchPosts(10);
		}
    };
});