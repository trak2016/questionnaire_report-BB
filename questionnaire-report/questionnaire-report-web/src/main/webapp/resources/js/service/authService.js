angular.module('authService', [])
    .factory('AuthService', ['$resource', '$rootScope', function($resource, $rootScope) {
        return {
            readUser: $resource('../api/auth/logged', {}),
            readLoggedUserOrEmpty: $resource('../api/auth/user', {}), 
            setUser: function(data) {
                $rootScope.authData = data;
            }
        };
}]);