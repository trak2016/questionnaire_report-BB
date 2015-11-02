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
                data: {pageTitle: 'Ankiety'}
            })


}
angular
        .module('inspinia')
        .config(config)
        .run(function ($rootScope, $state) {
            $rootScope.$state = $state;
        });
