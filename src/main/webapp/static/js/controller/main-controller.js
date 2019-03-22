angular.module('main', ['ngSanitize', 'ngAnimate', 'ngTouch']).controller('mainController', ['$scope', 'mainService', function($scope, mainService) {
	$scope.posts = {};
	$scope.postMain = {};
	$scope.postAdd = {
		pics: [],
		address: []
	};
	$scope.picsDto = [];
	$scope.addressDto = [];
	$scope.stars = [];
	$scope.menu = 'post';
	$scope.sortListBy = 'title';
	$scope.asc = true;
	$scope.currentPage = 1;
	$scope.pages = [1,2,3,4,5,6,7,8,9,10];
	$scope.dataPerPage = 10;
	$scope.clickCC = 0;
	$scope.showManagerBtn = false;
	$scope.showErrorMsg = false;
	$scope.showWarningMsg = false;
	
	//******** PHOTO ALBUM ****************

	// initial image index
    $scope._Index = 0;
    // if a current image is the same as requested image
    $scope.isActive = function (index) {
        return $scope._Index === index;
    }
    // show prev image
    $scope.showPrev = function () {
        $scope._Index = ($scope._Index > 0) ? --$scope._Index : $scope.postMain.pics.length - 1;
    }
    // show next image
    $scope.showNext = function () {
        $scope._Index = ($scope._Index < $scope.postMain.pics.length - 1) ? ++$scope._Index : 0;
    }
    // show a certain image
    $scope.showPhoto = function (index) {
        $scope._Index = index;
    }
	
	//*************************
    
    $scope.savePost = function(){
    	$scope.postAdd.pics = $scope.picsDto;
    	$scope.postAdd.address = $scope.addressDto;
    	mainService.savePost($scope.postAdd).then(
            function(response) {
            	document.body.scrollTop = 0;
            	document.documentElement.scrollTop = 0;
            	$scope.showWarningMsg = true;
            	$scope.$apply; 
            },
            function(errResponse){
            	$scope.showErrorMsg = true;
                console.log('Error while savePost Posts');
            }
        );
    }

    $scope.addVisitor = function(postId, value){
    	mainService.addVisitor(postId, value).then(
            function(response) {
            	$scope.postMain = response.data;
            	$scope.$apply;
            },
            function(errResponse){
                console.log('Error while addVisitor Posts');
            }
        );
    }
    
    $scope.addVisitor2 = function(postId, value){
    	mainService.addVisitor(postId, value).then(
            function(response) {},
            function(errResponse){
                console.log('Error while addVisitor Posts');
            }
        );
    }
    
    $scope.likePost = function(postId, value){
    	mainService.likePost(postId, value).then(
            function(response) {
            	$scope.postMain = response.data;
            	$scope.$apply;
            },
            function(errResponse){
                console.log('Error while likePost Posts');
            }
        );
    }
    
    $scope.dislikePost = function(postId, value){
    	mainService.dislikePost(postId, value).then(
            function(response) {
            	$scope.postMain = response.data;
            	$scope.$apply;
            },
            function(errResponse){
                console.log('Error while dislikePost Posts');
            }
        );
    }

    $scope.fetchHomePost = function(){
    	mainService.fetchHomePost().then(
            function(response) {
            	$scope.posts = response.data;
            	$scope.postMain = $scope.posts[0]; 
            	$scope.$apply;
            	$scope.addVisitor2($scope.postMain.postId, 1);
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
    
	$scope.showManagerButton = function(){
		if($scope.clickCC === 4){
			$scope.clickCC = 0;
			$scope.showManagerBtn = true;
		}
		$scope.clickCC++;
	};
    
	$scope.menuChange = function(value) {
		$scope.menu = value;
    }
    
	$scope.sortPostList = function() {
		$scope.fetchPagination(1, $scope.dataPerPage, $scope.sortListBy, $scope.asc)
    };

}]);