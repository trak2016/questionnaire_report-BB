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
                                },
                                getAllActiveUser: {
                                    method: 'GET',
                                    url: '../api/task/allActiveUser',
                                    isArray: true,
                                    responseType: 'json'
                                },
                                getAllFinishUser: {
                                    method: 'GET',
                                    url: '../api/task/allFinishUser',
                                    isArray: true,
                                    responseType: 'json'
                                }
                            }
                    )
                };
            }]);

