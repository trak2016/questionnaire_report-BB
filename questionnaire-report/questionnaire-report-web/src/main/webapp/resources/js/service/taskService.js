angular.module('taskService', [])
        .factory('TaskService', ['$resource', function ($resource) {
                return {
                    api: $resource('../api/task', {},
                            {
                                getAllActive: {
                                    method: 'GET',
                                    url: '../api/task/allActive',
                                    isArray: true,
                                    responseType: 'json'
                                },
                                getAllFinish: {
                                    method: 'GET',
                                    url: '../api/task/allFinish',
                                    isArray: true,
                                    responseType: 'json'
                                }
                            }
                    )
                };
            }]);

