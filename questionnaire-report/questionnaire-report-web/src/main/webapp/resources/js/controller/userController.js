angular.module('userController', [])
        .controller('userController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'DTOptionsBuilder', 'DTColumnDefBuilder', 'UserService',
            function ($scope, $rootScope, $state, $http, toastr, DTOptionsBuilder, DTColumnDefBuilder, UserService) {

                $scope.users = [];

                UserService.api.getAll().$promise.then(function (result) {
                    $scope.users = result;
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

                $scope.blockUnlock = function (id) {
                    swal({
                        title: "",
                        text: "Na pewno chcesz zablokować/odblokować konto użytkownika?",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "Tak",
                        cancelButtonText: "Nie",
                        closeOnConfirm: true
                    }, function () {
                        UserService.api.blockUnlockById({'id': id}).$promise.then(function (result) {
                            toastr.success('Operacja zakończyła się sukcesem.', 'Powodzenie!');
                            UserService.api.getAll().$promise.then(function (result) {
                                $scope.users = result;
                            });
                        });
                    });
                };

            }])
        