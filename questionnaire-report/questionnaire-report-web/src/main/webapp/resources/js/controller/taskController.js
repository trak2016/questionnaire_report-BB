angular.module('taskController', [])
        .controller('taskActiveController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'DTOptionsBuilder', 'DTColumnDefBuilder', 'TaskService',
            function ($scope, $rootScope, $state, $http, toastr, DTOptionsBuilder, DTColumnDefBuilder, TaskService) {

                $scope.tasks = [];


                TaskService.api.getAllActive().$promise.then(function (result) {
                    $scope.tasks = result;
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
                            .notSortable()
                            .withOption('defaultContent', "")
                ];


            }])
        .controller('taskFinishController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'DTOptionsBuilder', 'DTColumnDefBuilder', 'TaskService',
            function ($scope, $rootScope, $state, $http, toastr, DTOptionsBuilder, DTColumnDefBuilder, TaskService) {

                $scope.tasks = [];


                TaskService.api.getAllFinish().$promise.then(function (result) {
                    $scope.tasks = result;
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
                            .notSortable()
                            .withOption('defaultContent', "")
                ];


            }])
        .controller('taskUserActiveController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'DTOptionsBuilder', 'DTColumnDefBuilder', 'TaskService',
            function ($scope, $rootScope, $state, $http, toastr, DTOptionsBuilder, DTColumnDefBuilder, TaskService) {

                $scope.tasks = [];


                TaskService.api.getAllActiveUser().$promise.then(function (result) {
                    $scope.tasks = result;
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
                            .notSortable()
                            .withOption('defaultContent', "")
                ];

                $scope.fillQuestionnaire = function(id){
                    $state.go('task.questionnaire', {id : id});
                }
                ;

            }])
        .controller('taskUserFinishController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'DTOptionsBuilder', 'DTColumnDefBuilder', 'TaskService',
            function ($scope, $rootScope, $state, $http, toastr, DTOptionsBuilder, DTColumnDefBuilder, TaskService) {

                $scope.tasks = [];


                TaskService.api.getAllFinishUser().$promise.then(function (result) {
                    $scope.tasks = result;
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
                            .notSortable()
                            .withOption('defaultContent', "")
                ];


            }])
        .controller('questionnaireTaskController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'QuestionnaireService', 'DTOptionsBuilder', 'DTColumnDefBuilder', '$stateParams', '$location',
            function ($scope, $rootScope, $state, $http, toastr, QuestionnaireService, DTOptionsBuilder, DTColumnDefBuilder, $stateParams, $location) {


                QuestionnaireService.api.getById({"questionnaireId": $stateParams.id}).$promise.then(function (result) {
                    $scope.questionnaire = result;
                });

                $scope.sendQuestionnaire = function () {
                    var questionnaire = $scope.questionnaire;
                    QuestionnaireService.api.send(questionnaire).$promise.then(function (result) {
                        $state.go('task.listUserActive');
                    });
                };

                $scope.cancelFillQuestionnaire = function () {
                    swal({
                        title: "",
                        text: "Jesteś pewny, że chcesz opuścić ankietę?",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "Tak",
                        cancelButtonText: "Nie",
                        closeOnConfirm: true
                    }, function () {
                        $state.go('task.listUserActive');
                        ;
                    });
                };
            }])
