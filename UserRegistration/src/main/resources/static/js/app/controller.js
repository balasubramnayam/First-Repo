'use strict';
angular.module('crudApp').controller('myController1',
    ['myService', '$scope',  function( myService, $scope) {

        var self = this;
        self.user = {};
        self.users=[];

        self.submit = submit;
        self.getAllUsers = getAllUsers;
        self.createUser = createUser;
        self.updateUser = updateUser;
        self.removeUser = removeUser;
        self.editUser = editUser;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.user.userId === undefined || self.user.userId === null) {
                console.log('Saving New User', self.user);
                createUser(self.user);
            } else {
                updateUser(self.user, self.user.userId);
                console.log('User updated with id ', self.user.userId);
            }
        }

        function createUser(user) {
            console.log('About to create user');
            myService.createUser(user)
                .then(
                    function (response) {
                        console.log('User created successfully');
                        self.successMessage = 'User created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.user={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating User');
                        self.errorMessage = 'Error while creating User: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateUser(user, userId){
            console.log('About to update user');
            myService.updateUser(user, userId)
                .then(
                    function (response){
                        console.log('User updated successfully');
                        self.successMessage='User updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating User');
                        self.errorMessage='Error while updating User '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeUser(userId){
            console.log('About to remove User with id '+userId);
            myService.removeUser(userId)
                .then(
                    function(){
                        console.log('User '+userId + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing user '+userId +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllUsers(){
            return myService.getAllUsers();
        }

        function editUser(userId) {
            self.successMessage='';
            self.errorMessage='';
            myService.getUser(userId).then(
                function (user) {
                    self.user = user;
                },
                function (errResponse) {
                    console.error('Error while removing user ' + userId + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.user={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);