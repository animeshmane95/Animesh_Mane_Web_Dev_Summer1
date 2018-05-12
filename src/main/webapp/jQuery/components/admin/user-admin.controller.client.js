var userName 
var password  
var email     
var firstName 
var lastName  
var phone     
var role      
var dob
$(document).ready(main);

function main(){
	
	alert("this function should be executed first");
	 $("#button2").click(createUser);
}

function createUser(){
	 userName  = $("#usernameFld").val()
	 password  = $("#passwordFld").val()
	 email     = $("#emailFld").val()
	 firstName = $("#firstNameFld").val()
	 lastName  = $("#lastNameFld").val()
	 phone     = $("#PhoneFld").val()
	 role      = $("#roleFld").val()
	 dob       = $("#DOBFld").val()
	
	
var newUser = new User(userName,password,email,firstName,lastName,phone,role,dob);
alert("creating new user");

var clientService = new UserServiceClient;
clientService.createUser(newUser);

}

	
