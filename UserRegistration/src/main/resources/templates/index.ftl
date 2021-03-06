<!DOCTYPE html>
<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
    </head>
    <body>

        <div ui-view></div>
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/service.js"></script>
        <script src="js/app/controller.js"></script>
    </body>
</html>