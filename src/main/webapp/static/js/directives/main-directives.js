angular.module('main').directive('postPage', function () {
	return {
        templateUrl: 'post',
		restrict: 'AE',
		controller: 'mainController',
		link: function($scope, $element, $attrs, ctrl){
			$scope.fetchHomePost();
		    
		    $scope.addVisitorDir = function(post, value) {
		    	$scope.addVisitor(post.objectId, value);
		    };
		    
		    $scope.likePostDir = function(post, value) {
		    	$scope.likePost(post.objectId, value);
		    };
		    
		    $scope.dislikePostDir = function(post, value) {
		    	$scope.dislikePost(post.objectId, value);
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
			$scope.sortPostList();
			
		    $scope.addVisitorDir = function(post, value) {
		    	$scope.addVisitor(post.objectId, value);
		    };
		}
    };
});