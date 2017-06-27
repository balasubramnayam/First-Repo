<!DOCTYPE html>
<html>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">User </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.user.userId" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="firstName">First Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.firstName" id="firstName" class="username form-control input-sm" placeholder="Enter your First name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="lastName">Last Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.lastName" id="lastName" class="username form-control input-sm" placeholder="Enter your Last name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="birthDate">DOB</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.birthDate" id="birthDate" datetime="yyyy-MM-dd HH:mm:ss" class="username form-control input-sm" placeholder="Enter your DOB here" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="cityName">City</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.cityName" id="cityName" class="username form-control input-sm" placeholder="Enter your City name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="pinCode">Pin</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.pinCode" id="pinCode" class="form-control input-sm" placeholder="Enter your Pin Code" required ng-pattern="ctrl.onlyNumbers"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.user.userId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover" border="1">
		            <thead>
		            <tr>
		                <th>USER ID</th>
		                <th>FRIST NAME</th>
		                <th>LAST NAME</th>
		                <th>DOB</th>
		                <th>CITY</th>
		                <th>PIN CODE</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllUsers()">
		                <td>{{u.userId}}</td>
		                <td>{{u.firstName}}</td>
		                <td>{{u.lastName}}</td>
		                <td>{{u.birthDate}}</td>
		                <td>{{u.cityName}}</td>
		                <td>{{u.pinCode}}</td>
		                <td><button type="button" ng-click="ctrl.editUser(u.userId)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeUser(u.userId)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>
</html>