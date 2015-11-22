(function () {
    angular.module('inspinia', [
        'ui.router', // Routing
        'angularValidator',
        'oc.lazyLoad', // ocLazyLoad
        'ui.bootstrap', // Ui Bootstrap
        'pascalprecht.translate', // Angular Translate
        'ngIdle', // Idle timer
        'ngResource',
        'cgNotify',
        'datatables',
        'toastr',
        'ngAnimate',
        // controllers
        'questionnaireController',
        'profilController',
        'archiveController',
        'taskController',
        'userController',
        // services
        'authService',
        'questionnaireService',
        'profilService',
        'userService',
        'taskService'
        // directives
        
        // Idle timer
    ])
})();

// Other libraries are loaded dynamically in the config.js file using the library ocLazyLoad