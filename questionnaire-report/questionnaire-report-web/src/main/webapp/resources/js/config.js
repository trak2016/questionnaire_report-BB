function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, IdleProvider, KeepaliveProvider) {

    // Configure Idle settings
    IdleProvider.idle(5); // in seconds
    IdleProvider.timeout(120); // in seconds

    $urlRouterProvider.otherwise("questionnaire/list");

    $ocLazyLoadProvider.config({
        // Set to true if you want to see what and when is dynamically loaded
        debug: false
    });

    $stateProvider

            .state('questionnaire', {
                abstract: true,
                url: "/questionnaire",
                templateUrl: "views/common/content.html"
            })
            .state('questionnaire.list', {
                url: "/list",
                templateUrl: "views/questionnaire/list.html",
                controller: "questionnaireController",
                data: {pageTitle: 'Szablony'}
            })
            .state('questionnaire.listDone', {
                url: "/listDone",
                templateUrl: "views/questionnaire/listDone.html",
                controller: "questionnaireDoneController",
                data: {pageTitle: 'Ankiety zatwierdzone'}
            })
            .state('questionnaire.create', {
                url: "/create",
                templateUrl: "views/questionnaire/create.html",
                controller: "questionnaireCreateController",
                data: {pageTitle: 'Edytor ankiety'},
                resolve: {
                    loadPlugin: function ($ocLazyLoad) {
                        return $ocLazyLoad.load([
                            {
                                name: 'ui.sortable',
                                files: ['js/plugins/ui-sortable/sortable.js']
                            },
                            {
                                name: 'ui.tree',
                                files: ['css/plugins/uiTree/angular-ui-tree.min.css', 'css/tree-node.css', 'js/plugins/uiTree/angular-ui-tree.min.js']
                            }
                        ]);
                    }
                }
            })
            .state('archive', {
                abstract: true,
                url: "/archive",
                templateUrl: "views/common/content.html"
            })
            .state('archive.list', {
                url: "/list",
                templateUrl: "views/archive/list.html",
                controller: "archiveController",
                data: {pageTitle: 'Archiwum'}
            })
            .state('profil', {
                abstract: true,
                url: "/profil",
                templateUrl: "views/common/content.html"
            })
            .state('profil.profil', {
                url: "/profil",
                templateUrl: "views/profil/profil.html",
                controller: "profilController",
                data: {pageTitle: 'Profil'}
            })
            .state('task', {
                abstract: true,
                url: "/task",
                templateUrl: "views/common/content.html"
            })
            .state('task.list', {
                url: "/task",
                templateUrl: "views/task/list.html",
                controller: "taskController",
                data: {pageTitle: 'Zadania'}
            })


}
angular
        .module('inspinia')
        .config(config)
        .config(function (toastrConfig) {
            angular.extend(toastrConfig, {
                autoDismiss: false,
                closeButton: true,
                extendedTimeOut: 1000,
                progressBar: true,
                timeOut: 5000
            });
        })
        .run(function ($rootScope, $state) {
            $rootScope.$state = $state;
        });
