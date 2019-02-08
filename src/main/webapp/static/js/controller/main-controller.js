angular.module('main', ['ngSanitize', 'ngAnimate', 'ngTouch']).controller('mainController', ['$scope', 'mainService', function($scope, mainService) {
	$scope.posts = {};
	$scope.postMain;
	$scope.stars = [];
	$scope.menu = 'post';
	$scope.sortListBy = 'title';
	$scope.asc = true;
	$scope.currentPage = 1;
	$scope.pages = [1,2,3,4,5,6,7,8,9,10];
	$scope.dataPerPage = 10;
	
	//************************
	
    $scope.photos = [
        {src: 'http://farm9.staticflickr.com/8042/7918423710_e6dd168d7c_b.jpg', desc: 'Image 01'},
        {src: 'http://farm9.staticflickr.com/8449/7918424278_4835c85e7a_b.jpg', desc: 'Image 02'},
        {src: 'http://farm9.staticflickr.com/8457/7918424412_bb641455c7_b.jpg', desc: 'Image 03'},
        {src: 'http://farm9.staticflickr.com/8179/7918424842_c79f7e345c_b.jpg', desc: 'Image 04'},
        {src: 'http://farm9.staticflickr.com/8315/7918425138_b739f0df53_b.jpg', desc: 'Image 05'},
        {src: 'http://farm9.staticflickr.com/8461/7918425364_fe6753aa75_b.jpg', desc: 'Image 06'}
    ];
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
    
	$scope.menuChange = function(value) {
		$scope.menu = value;
    }
    
	$scope.sortPostList = function() {
		$scope.fetchPagination(1, $scope.dataPerPage, $scope.sortListBy, $scope.asc)
    };

}]);