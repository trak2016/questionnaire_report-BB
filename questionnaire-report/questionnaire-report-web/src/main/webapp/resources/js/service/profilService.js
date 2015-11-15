angular.module('profilService', [])
    .factory('ProfilService', ['$resource', function($resource) {
        return {
            api: $resource('../api/profil', {},
                {
                    current: {
                        method: 'GET',
                        url: '../api/profil/current',
                        responseType: 'json'
                    },
                    change: {
                        method: 'POST',
                        url: '../api/profil/change',
                        responseType: 'json'
                    }
                }
            )
        };
}]);

