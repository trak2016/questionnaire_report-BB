angular.module('questionnaireController', [])
        .controller('questionnaireController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'QuestionnaireService', 'DTOptionsBuilder', 'DTColumnDefBuilder',
            function ($scope, $rootScope, $state, $http, toastr, QuestionnaireService, DTOptionsBuilder, DTColumnDefBuilder) {

                $scope.questionnaires = [];

                QuestionnaireService.api.getAll().$promise.then(function (result) {
                    $scope.questionnaires = result;
                });

                $scope.dtOptions = DTOptionsBuilder.newOptions()
                        .withOption('info', false)
                        .withDisplayLength(5)
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
        