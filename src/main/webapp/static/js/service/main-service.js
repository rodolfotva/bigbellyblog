angular.module('main').factory('mainService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_POST_URI = 'http://localhost:8082/bigbellyblog/post/';
    var REST_SERVICE_POST_BY_ALPHA_URI = 'http://localhost:8082/bigbellyblog/post/alpha';
    var REST_SERVICE_PAGE_POST_URI = 'http://localhost:8082/bigbellyblog/post/pagination';
    var REST_SERVICE_LIKE_POST_URI = 'http://localhost:8082/bigbellyblog/post/like';
    var REST_SERVICE_DISLIKE_POST_URI = 'http://localhost:8082/bigbellyblog/post/dislike';
    var REST_SERVICE_VISITOR_POST_URI = 'http://localhost:8082/bigbellyblog/post/addVisitor';
 
    var factory = {
    	fetchHomePost:fetchHomePost,
    	fetchPosts:fetchPosts,
    	fetchPostsByAlpha:fetchPostsByAlpha,
    	fetchPagination:fetchPagination,
    	likePost:likePost,
    	dislikePost:dislikePost,
    	addVisitor:addVisitor
    };
 
    return factory;

    function addVisitor(objectId, value) {
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_VISITOR_POST_URI+"/"+value+"/"+objectId).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                console.log('Error while addVisitor to post');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function likePost(objectId, value) {
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_LIKE_POST_URI+"/"+value+"/"+objectId).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                console.log('Error while like post');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function dislikePost(objectId, value) {
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_DISLIKE_POST_URI+"/"+value+"/"+objectId).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                console.log('Error while dislike post');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function fetchHomePost() {
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_POST_URI).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                console.log('Error while fetching post');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchPosts(limit) {
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_POST_URI+"/"+limit).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                console.log('Error while fetching posts');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchPostsByAlpha() {
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_POST_BY_ALPHA_URI).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                console.log('Error while fetching posts');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchPagination(page, dataPerPage, sortBy, asc) {
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_PAGE_POST_URI+"/"+page+"/"+dataPerPage+"/"+sortBy+"/"+asc).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                console.log('Error while fetching posts pagination');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
}]);