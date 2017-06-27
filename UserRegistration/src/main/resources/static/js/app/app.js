var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:9999/UserRegistration',
    USER_SERVICE_API : 'http://localhost:9999/UserRegistration/registration/user/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'myController1',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, myService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        myService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

