angular.module('userService', [])
        .factory('UserService', ['$resource', function ($resource) {
                return {
                    api: $resource('../api/userdata', {},
                            {
                                getAll: {
                                    method: 'GET',
                                    url: '../api/userdata/all',
                                    responseType: 'json',
                                    isArray: true

                                },
                                blockUnlockById: {
                                    method: 'GET',
                                    url: '../api/userdata/blockunlock/:id',
                                    params: {id: '@id'},
                                    responseType: 'json'
                                },
                            }
                    )
                };
            }]);

