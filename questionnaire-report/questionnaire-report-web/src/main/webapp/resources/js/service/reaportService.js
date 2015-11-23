angular.module('reaportService', [])
        .factory('ReaportService', ['$resource', function ($resource) {
                return {
                    api: $resource('../api/reaport', {},
                            {
                                getGeneralReaport: {
                                    method: 'GET',
                                    url: '../api/reaport/general/:id',
                                    params: {id: '@id'},
                                    responseType: 'json'
                                },
                            }
                    )
                };
            }]);

