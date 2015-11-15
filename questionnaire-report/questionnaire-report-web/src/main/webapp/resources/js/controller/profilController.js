angular.module('profilController', [])
        .controller('profilController', ['$scope', '$rootScope', '$state', '$http', 'toastr', 'ProfilService',
            function ($scope, $rootScope, $state, $http, toastr, ProfilService) {
                
                $scope.user = {};
                var load = function () {
                    ProfilService.api.current().$promise.then(function (result) {
                        $scope.user = result;
                    });
                };
                load();

                $scope.updateUserData = function () {
                    ProfilService.api.change($scope.user).$promise.then(function (result) {
                        $scope.user = result;
                        $rootScope.authData.name = $scope.user.name;
                        $rootScope.authData.surname = $scope.user.surname;
                        toastr.success("Dane zostały zmienione.", "Powodzenie!");
                    });
                };
                


            }])


