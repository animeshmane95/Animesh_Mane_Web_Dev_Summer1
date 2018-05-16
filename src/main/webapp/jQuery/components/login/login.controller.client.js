$( document ).ready(function() {
 var userService = new UserServiceClient();
 $(main);
 
 function main(){
	 $(document).on('click','#login-button',function(){
		 var username = $("#login-username").val()
		 var password = $("#login-password").val();
		 login(username,password);
		 });
	 $(document).on('click','#login-page-signUp-button',function(){
		 window.location = "../../register/register.template.client.html"
		 
	 });
 }
 
 function login(username,password){
	 var newUser = new User(username,password,null,null,null,null,null,null);
	 var validation = userService.login(newUser).then(function(results){
		 var response = results
		 //bonus part account validation
		 if(response.username == null){
			 var response = userService.findUserbyUserName(username).then(function(results){
				 var respo = results;
				 if(respo.exists == 'true'){
					 alert("Account Validation Failed!!!Incorrect Password");
				 }
				 else{alert("Account Validation Failed!!!  Username does not exists");}
				 });
		 }

		 else {
			 alert("Welcome"+  " " + response.username)
			 window.location = "../profile/profile.template.client.html" 
			 }
		 
	 });
	 
	  $("#login-username").val("")
	  $("#login-password").val("");
	 
	 }

	 

	 
});