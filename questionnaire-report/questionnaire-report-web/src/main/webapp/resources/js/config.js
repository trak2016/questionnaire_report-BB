function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, IdleProvider, KeepaliveProvider) {

    // Configure Idle settings
    IdleProvider.idle(5); // in seconds
    IdleProvider.timeout(120); // in seconds

    $urlRouterProvider.otherwise("profil/profil");

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
            .state('questionnaire.listFinish', {
                url: "/listFinish",
                templateUrl: "views/questionnaire/listFinish.html",
                controller: "questionnaireFinishController",
                data: {pageTitle: 'Ankiety zakończone'}
            })
            .state('questionnaire.create', {
                url: "/create/:questionnaireId",
                templateUrl: "views/questionnaire/create.html",
                controller: "questionnaireCreateController",
                data: {pageTitle: 'Edytor ankiety'},
                resolve: {
                    loadPlugin: function ($ocLazyLoad) {
                        return $ocLazyLoad.load([
                            {
                                insertBefore: '#loadBefore',
                                name: 'angular.chosen',
                                files: ['css/plugins/chosen/chosen.css', 'js/plugins/chosen/chosen.jquery.js', 'js/plugins/angular-chosen/angular-chosen.js']
                            },
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
            .state('task.listActive', {
                url: "/taskActive",
                templateUrl: "views/task/listActive.html",
                controller: "taskActiveController",
                data: {pageTitle: 'Aktywne zadania'}
            })
            .state('task.listFinish', {
                url: "/taskFinish",
                templateUrl: "views/task/listFinish.html",
                controller: "taskFinishController",
                data: {pageTitle: 'Zakończone zadania'}
            })
            .state('task.listUserActive', {
                url: "/taskUserActive",
                templateUrl: "views/task/listUserActive.html",
                controller: "taskUserActiveController",
                data: {pageTitle: 'Aktywne zadania'}
            })
            .state('task.listUserFinish', {
                url: "/taskUserFinish",
                templateUrl: "views/task/listUserFinish.html",
                controller: "taskUserFinishController",
                data: {pageTitle: 'Zakończone zadania'}
            })
            .state('task.questionnaire', {
                url: "/questionnaire?id",
                templateUrl: "views/questionnaire/questionnaire.html",
                controller: "questionnaireTaskController",
                data: {pageTitle: 'Ankieta'}
            })
            .state('user', {
                abstract: true,
                url: "/user",
                templateUrl: "views/common/content.html"
            })
            .state('user.list', {
                url: "/userlist",
                templateUrl: "views/user/list.html",
                controller: "userController",
                data: {pageTitle: 'Użytkownicy systemu'}
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
        .run(function ($rootScope, $state, AuthService, $q) {
            $rootScope.$state = $state;
            $rootScope.syn = $q.defer();
            $rootScope.SERVER_DEF_URL = "http://localhost:8085/questionnaire-report";
            $rootScope.BASE_URL = "/questionnaire-report";

            AuthService.readUser.get().$promise.then(function (result) {
                AuthService.setUser(result);
                $rootScope.syn.resolve();
            });
        });
