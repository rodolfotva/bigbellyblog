angular.module('main', ['ngSanitize']).controller('mainController', ['$scope', 'mainService', function($scope, mainService) {
	$scope.posts = {};
	$scope.postMain;
	$scope.stars = [];
	$scope.menu = 'post';
	$scope.sortListBy = 'title';
	$scope.asc = true;
	$scope.currentPage = 1;
	$scope.pages = [1,2,3,4,5,6,7,8,9,10];
	$scope.dataPerPage = 10;

    $scope.fetchHomePost = function(){
    	mainService.fetchHomePost().then(
            function(response) {
            	$scope.posts = response.data;
            	$scope.postMain = $scope.posts[0]; 
            	$scope.$apply;
            },
            function(errResponse){
                console.log('Error while fetching home Posts');
            }
        );
    }
    
    $scope.fetchPostsByAlpha = function(){
    	mainService.fetchPostsByAlpha().then(
            function(response) {
            	$scope.posts = response.data;
            	$scope.$apply;
            },
            function(errResponse){
                console.log('Error while fetching home Posts');
            }
        );
    }

    $scope.fetchPosts = function(limit){
    	mainService.fetchPosts(limit).then(
            function(response) {
            	$scope.posts = response.data;
            	$scope.$apply;
            },
            function(errResponse){
                console.log('Error while fetching Posts');
            }
        );
    }
    
    $scope.fetchPagination = function(page, dataPerPage, sortBy, asc){
    	console.log(page+'-'+dataPerPage+'-'+sortBy+'-'+asc);
    	mainService.fetchPagination(page, dataPerPage, sortBy, asc).then(
            function(response) {
            	$scope.posts = response.data;
            	$scope.currentPage = page;
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
    }
    
	$scope.sortPostList = function() {
		$scope.fetchPagination(1, $scope.dataPerPage, $scope.sortListBy, $scope.asc)
    };

}]);