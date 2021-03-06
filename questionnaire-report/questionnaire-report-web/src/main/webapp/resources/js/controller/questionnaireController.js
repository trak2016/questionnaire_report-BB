angular.module('questionnaireController', ['ui.bootstrap'])
        .controller('questionnaireController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'QuestionnaireService', 'DTOptionsBuilder', 'DTColumnDefBuilder',
            function ($scope, $rootScope, $state, $http, toastr, QuestionnaireService, DTOptionsBuilder, DTColumnDefBuilder) {

                $scope.questionnaires = [];

                QuestionnaireService.api.getAllTemplate().$promise.then(function (result) {
                    $scope.questionnaires = result;
                });

                $scope.dtOptions = DTOptionsBuilder.newOptions()
                        .withOption('info', false)
                        .withDisplayLength(10)
                        .withLanguage({
                            "sInfo": "",
                            "sLengthMenu": "Pokaż _MENU_ pozycji",
                            "sSearch": "Wyszukaj:",
                            "sLoadingRecords": "Ładowanie danych...",
                            "oPaginate": {
                                "sFirst": "|<",
                                "sLast": ">|",
                                "sNext": ">>",
                                "sPrevious": "<<"
                            }
                        })

                        ;

                $scope.dtColumnDefs = [
                    DTColumnDefBuilder
                            .newColumnDef(0)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(1)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(2)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(3)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(4)
                            .notSortable()
                            .withOption('defaultContent', "")
                ];

                $scope.addQuestionnaire = function () {
                    $state.go('questionnaire.create');
                };

                $scope.editQuestionnaire = function (id) {
                    $state.go('questionnaire.create', {questionnaireId: id});
                };

                $scope.startQuestionnaire = function (id) {
                    swal({
                        title: "",
                        text: "Na pewno chcesz wystartować ankietę?",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "Tak",
                        cancelButtonText: "Nie",
                        closeOnConfirm: true
                    }, function () {
                        QuestionnaireService.api.startQuestionnaire({'id': id}).$promise.then(function (result) {
                            $state.go('questionnaire.listDone');
                            toastr.success('Ankieta została wystartowana.', 'Powodzenie!');
                        });
                    });
                };

                $scope.deleteQuestionnaire = function (id) {
                    swal({
                        title: "",
                        text: "Na pewno chcesz usunąć ankietę?",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "Tak",
                        cancelButtonText: "Nie",
                        closeOnConfirm: true
                    }, function () {
                        QuestionnaireService.api.deleteById({'questionnaireId': id}).$promise.then(function (result) {
                            toastr.success('Ankieta została usunięta.', 'Powodzenie!');
                            QuestionnaireService.api.getAllTemplate().$promise.then(function (result) {
                                $scope.questionnaires = result;
                            });
                        });
                    });
                };


            }])
        .controller('questionnaireCreateController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'QuestionnaireService', 'DTOptionsBuilder', 'DTColumnDefBuilder', '$modal', '$stateParams', 'UserService',
            function ($scope, $rootScope, $state, $http, toastr, QuestionnaireService, DTOptionsBuilder, DTColumnDefBuilder, $modal, $stateParams, UserService) {

                $scope.questionnaire = {};
                $scope.questionnaire.questions = [];
                $scope.questionnaire.users = [];
                $scope.newusers = [];

                UserService.api.getAll().$promise.then(function (result) {
                    $scope.allUsers = result;
                });

                $scope.addUsers = function () {
                    $scope.questionnaire.users = $scope.questionnaire.users.concat($scope.newusers);
                    $scope.newusers = [];
                };
                $scope.removeUser = function (user) {
                    var idx = $scope.questionnaire.users.indexOf(user);
                    if (idx >= 0) {
                        $scope.questionnaire.users.splice(idx, 1);
                        toastr.success('Użytkownik został usunięty.', 'Powodzenie!');
                    }
                };

                if ($stateParams.questionnaireId !== null && $stateParams.questionnaireId !== undefined) {
                    QuestionnaireService.api.getById({"questionnaireId": $stateParams.questionnaireId}).$promise.then(function (result) {
                        $scope.questionnaire = result;
                    });
                }

                $scope.addQuestionnaire = function () {
                    QuestionnaireService.api.save($scope.questionnaire).$promise.then(function (result) {
                        $state.go('questionnaire.list');
                    });
                };

                $scope.cancelQuestionnaire = function () {
                    $scope.questionnaire = {};
                    $state.go('questionnaire.list');
                };

                $scope.questionsSortableOptions = {
                    stop: function (e, ui) {
                        console.log($scope.questionnaire.questions);
                    }
                };

                $scope.deleteQuestion = function (question) {
                    swal({
                        title: "",
                        text: "Na pewno chcesz usunąć pytanie?",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "Tak",
                        cancelButtonText: "Nie",
                        closeOnConfirm: true
                    }, function () {
                        var idx = $scope.questionnaire.questions.indexOf(question);
                        if (idx >= 0) {
                            $scope.questionnaire.questions.splice(idx, 1);
                            toastr.success('Pytanie zostało usunięty.', 'Powodzenie!');
                        }
                        ;
                    });
                };

                $scope.open = function (questionEdit) {

                    $scope.editQuestionIdx = $scope.questionnaire.questions.indexOf(questionEdit);
                    var question = angular.copy(questionEdit);

                    var modalInstance = $modal.open({
                        templateUrl: 'views/questionnaire/modalQuestion.html',
                        controller: 'modalQuestionCreateController',
                        resolve: {
                            question: function () {
                                return question;
                            }
                        }
                    });

                    modalInstance.result.then(function (result) {
                        if (result.edit === false) {
                            $scope.questionnaire.questions.push(result.question);
                            toastr.success('Pytanie zostało dodane.', 'Powodzenie!');
                        }

                        else {
                            var v = $scope.questionnaire.questions[$scope.editQuestionIdx];
                            v.text = result.question.text;
                            v.type = result.question.type;
                            v.answers = result.question.answers;
                            toastr.success('Edycja przebiegła pomyślnie.', 'Powodzenie!');
                        }
                    }, function () {
                        $log.info('Modal dismissed at: ' + new Date());
                    });
                };

            }])

        .controller('modalQuestionCreateController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'question', '$modalInstance',
            function ($scope, $rootScope, $state, $http, toastr, question, $modalInstance) {

                $scope.question = question;

                if (question === undefined) {
                    $scope.edit = false;
                    $scope.question = {};
                    $scope.question.type = 'text';
                    $scope.question.answers = [];
                }
                else {
                    $scope.edit = true;
                }

                $scope.addQuestion = function () {
                    var result = {};
                    result.edit = $scope.edit;
                    result.question = $scope.question;
                    $modalInstance.close(result);
                };

                $scope.cancel = function () {
                    $modalInstance.dismiss('cancel');
                };

                $scope.addAnswer = function (answer) {
                    var answerr = new Object();
                    answerr.text = answer;
                    $scope.question.answers.push(answerr);
                    answer = {};
                };

                $scope.deleteAnswer = function (answer) {
                    swal({
                        title: "",
                        text: "Na pewno chcesz usunąć odpowiedź?",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "Tak",
                        cancelButtonText: "Nie",
                        closeOnConfirm: true
                    }, function () {
                        var idx = $scope.question.answers.indexOf(answer);
                        if (idx >= 0) {
                            $scope.question.answers.splice(idx, 1);
                            toastr.success('Odpowiedź została usunięta.', 'Powodzenie!');
                        }
                        ;
                    });
                };

            }])

        .controller('questionnaireDoneController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'QuestionnaireService', 'DTOptionsBuilder', 'DTColumnDefBuilder',
            function ($scope, $rootScope, $state, $http, toastr, QuestionnaireService, DTOptionsBuilder, DTColumnDefBuilder) {

                $scope.questionnaires = [];

                QuestionnaireService.api.getAllReady().$promise.then(function (result) {
                    $scope.questionnaires = result;
                });

                $scope.dtOptions = DTOptionsBuilder.newOptions()
                        .withOption('info', false)
                        .withDisplayLength(10)
                        .withLanguage({
                            "sInfo": "",
                            "sLengthMenu": "Pokaż _MENU_ pozycji",
                            "sSearch": "Wyszukaj:",
                            "sLoadingRecords": "Ładowanie danych...",
                            "oPaginate": {
                                "sFirst": "|<",
                                "sLast": ">|",
                                "sNext": ">>",
                                "sPrevious": "<<"
                            }
                        })

                        ;

                $scope.dtColumnDefs = [
                    DTColumnDefBuilder
                            .newColumnDef(0)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(1)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(2)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(3)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(4)
                            .notSortable()
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(5)
                            .notSortable()
                            .withOption('defaultContent', "")
                ];

                $scope.finishQuestionnaire = function (id) {
                    swal({
                        title: "",
                        text: "Na pewno chcesz zakończyć ankietę przed czasem?",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "Tak",
                        cancelButtonText: "Nie",
                        closeOnConfirm: true
                    }, function () {
                        QuestionnaireService.api.finishQuestionnaire({'id':id}).$promise.then(function (result) {
                            $state.go('questionnaire.listFinish');
                        });
                    });
                };

            }])
        .controller('questionnaireFinishController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'QuestionnaireService', 'DTOptionsBuilder', 'DTColumnDefBuilder',
            function ($scope, $rootScope, $state, $http, toastr, QuestionnaireService, DTOptionsBuilder, DTColumnDefBuilder) {

                $scope.questionnaires = [];

                QuestionnaireService.api.getAllFinish().$promise.then(function (result) {
                    $scope.questionnaires = result;
                });

                $scope.dtOptions = DTOptionsBuilder.newOptions()
                        .withOption('info', false)
                        .withDisplayLength(10)
                        .withLanguage({
                            "sInfo": "",
                            "sLengthMenu": "Pokaż _MENU_ pozycji",
                            "sSearch": "Wyszukaj:",
                            "sLoadingRecords": "Ładowanie danych...",
                            "oPaginate": {
                                "sFirst": "|<",
                                "sLast": ">|",
                                "sNext": ">>",
                                "sPrevious": "<<"
                            }
                        })

                        ;

                $scope.dtColumnDefs = [
                    DTColumnDefBuilder
                            .newColumnDef(0)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(1)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(2)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(3)
                            .withOption('defaultContent', ""),
                    DTColumnDefBuilder
                            .newColumnDef(4)
                            .notSortable()
                            .withOption('defaultContent', "")
                ];

            }])