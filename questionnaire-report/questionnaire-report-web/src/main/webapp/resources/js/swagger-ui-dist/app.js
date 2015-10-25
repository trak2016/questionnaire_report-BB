angular.module('docsApp', [])
        .controller('docsController', function ($scope, $timeout) {

            $scope.projects = [
                {
                    host: "",
                    name: "Wybierz projekt",
                    baseUrl: "",
                    docsUrl: ""
                },
                {
                    host: "/",
                    name: "Data Distributor",
                    baseUrl: "data-distributor-web",
                    docsUrl: "/api-docs"
                }
                
            ];

            $scope.search = {
                //init values
                project: $scope.projects[0],
                url: "" + $scope.projects[0].host + $scope.projects[0].baseUrl + $scope.projects[0].docsUrl
            };

            $scope.updateUrl = function () {
                $scope.search.url = $scope.search.project.host + $scope.search.project.baseUrl + "/api-docs";
            };
        });

