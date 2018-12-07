angular.module('main').factory('mainService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_POST_URI = 'http://localhost:8082/bigbellyblog/post/';
 
    var factory = {
    	fetchHomePost:fetchHomePost
    };
 
    return factory;
 
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
    
}]);