angular.module('reaportController', [])
        .controller('reaportController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'DTOptionsBuilder', 'DTColumnDefBuilder', 'ReaportService', 'QuestionnaireService',
            function ($scope, $rootScope, $state, $http, toastr, DTOptionsBuilder, DTColumnDefBuilder, ReaportService, QuestionnaireService) {

                QuestionnaireService.api.getAllFinish().$promise.then(function (result) {
                    $scope.questionnaires = result;
                });

                $scope.generateReaport = function (id) {
                    $state.go('reaport.general', {id: id});

                }

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
        .controller('generalReaportController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'DTOptionsBuilder', 'DTColumnDefBuilder', 'ReaportService', '$stateParams',
            function ($scope, $rootScope, $state, $http, toastr, DTOptionsBuilder, DTColumnDefBuilder, ReaportService, $stateParams) {

                ReaportService.api.getGeneralReaport({"id": $stateParams.id}).$promise.then(function (result) {
                    $scope.reaport = result;
                });

            }])
        