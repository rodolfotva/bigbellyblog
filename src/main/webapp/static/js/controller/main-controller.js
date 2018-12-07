angular.module('main', ['ngSanitize']).controller('mainController', ['$scope', 'mainService', function($scope, mainService) {
	$scope.posts = {};
	$scope.menu = 'post';

    $scope.fetchHomePost = function(){
    	mainService.fetchHomePost().then(
            function(response) {
            	$scope.posts = response.data;
            },
            function(errResponse){
                console.log('Error while fetching Posts');
            }
        );
    }
    
	$scope.menuChange = function(value) {
		$scope.menu = value;
    };
}]);