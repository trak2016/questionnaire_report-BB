angular.module('questionnaireService', [])
        .factory('QuestionnaireService', ['$resource', function ($resource) {
                return {
                    api: $resource('../api/questionnaire', {},
                            {
                                getAllTemplate: {
                                    method: 'GET',
                                    url: '../api/questionnaire/allTemplate',
                                    isArray: true,
                                    responseType: 'json'
                                },
                                getAllReady: {
                                    method: 'GET',
                                    url: '../api/questionnaire/allReady',
                                    isArray: true,
                                    responseType: 'json'
                                },
                                getAllFinish: {
                                    method: 'GET',
                                    url: '../api/questionnaire/allFinish',
                                    isArray: true,
                                    responseType: 'json'
                                },
                                save: {
                                    method: 'POST',
                                    url: '../api/questionnaire/add',
                                    responseType: 'json'
                                },
                                getById: {
                                    method: 'GET',
                                    url: '../api/questionnaire/get/:questionnaireId',
                                    params: {questionnaireId: '@questionnaireId'},
                                    responseType: 'json'
                                },
                                startQuestionnaire: {
                                    method: 'GET',
                                    url: '../api/questionnaire/start/:id',
                                    params: {id: '@id'},
                                    responseType: 'json'
                                },
                            }
                    )
                };
            }]);




