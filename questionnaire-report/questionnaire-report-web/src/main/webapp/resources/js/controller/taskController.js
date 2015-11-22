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
