angular.module('main', ['ngSanitize']).controller('mainController', ['$scope', 'mainService', function($scope, mainService) {
	$scope.posts = {};
	$scope.postMain;
	$scope.stars = [];
	$scope.menu = 'post';

    $scope.fetchHomePost = function(){
    	mainService.fetchHomePost().then(
            function(response) {
            	$scope.posts = response.data;
            	$scope.postMain = $scope.posts[0]; 
            	$scope.$apply;
            },
            function(errResponse){
                console.log('Error while fetching Posts');
            }
        );
    }
    
    $scope.rateCalculation = function(rate){
    	$scope.stars = [];
    	var noRate = 5 - rate;
    	for(var x = 0; x < rate; x++){
    		$scope.stars.push('fa fa-star');
    	}
    	for(var y = 0; y < noRate; y++){
    		$scope.stars.push('fa fa-star-o');
    	}
    	return $scope.stars;
    }
    
	$scope.menuChange = function(value) {
		$scope.menu = value;
    };

}]);