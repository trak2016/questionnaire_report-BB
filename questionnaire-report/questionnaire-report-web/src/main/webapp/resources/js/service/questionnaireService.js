angular.module('questionnaireService', [])
        .factory('QuestionnaireService', ['$resource', function ($resource) {
                return {
                    api: $resource('../api/questionnaire', {},
                            {
                                
                                getAll: {
                                    method: 'GET',
                                    url: '../api/questionnaire/all',
                                    isArray: true,
                                    responseType: 'json'
                                },
                                
                            }
                    )
                };
            }]);




