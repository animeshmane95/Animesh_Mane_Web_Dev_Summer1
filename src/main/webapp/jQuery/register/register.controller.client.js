$( document ).ready(function() {
 var userService = new UserServiceClient();
	 $(main)
	 
	 
	 function main()
	 
	 {
		 $("#username").blur(findByUserName)
		 $(document).on('click','#submitUser',function(){registerUser();});
		 
	 }	
	 
	
	 
	 function findByUserName()
	 {
		var userName = $("#username").val();
		
		if (userName == ""){
			$('#submitUser').attr('disabled', true);
			alert("Registration unsuccessful!! Username cannot be null.Please try other user name!");
			alert("Submit button disabled due to unsuccessful registration. Please reload page to register again!");
		}
		
		else{
	    
		 var response = userService.findUserbyUserName(userName).then(function(results){
			    var respo = results;
			    if(respo.exists == 'true')
			    	{
			    			$('#submitUser').attr('disabled', true);
			    			alert("Registration unsuccessful!! Username already exists.Please try other user name!");
			    			alert("Submit button disabled due to unsuccessful registration. Please reload page to register again!");		    			
			    	}
			    
		 });
		 }
		 
		
		 		 
	 }
	 
	 function registerUser(){
		 var confirmPassword = $("#confirm-password").val();
		 var password = $("#password").val();
		 var userN = $("#username").val();
		 var user = new User(userN,password,null,null,null,null,null,null);
		 if (confirmPassword != password){
			 if (confirmPassword == ""){
				 alert("Password Validation failed.Confirm Password field is empty!")
				 alert("Registration unsuccessful!! Confirm Password field is empty.Please Try Again!")
				 $("#username").val('');
				 $("#password").val('');
				 $("#confirm-password").val('');
			 }
			 
			 else if (password == ""){
				 alert("Password Validation failed.Password field is empty!")
				 alert("Registration unsuccessful!! Password field empty. Please Try Again!")
				 $("#username").val('');
				 $("#password").val('');
				 $("#confirm-password").val('');
			 }
			 
			 else {
				 alert("Password Validation failed. Passwords do not match!")
				 alert("Registration unsuccessful!! Passwords do not match .Please Try Again!");
				 $("#username").val('');
				 $("#password").val('');
				 $("#confirm-password").val('');
			 }

		 }
		 
		 
		 else{
			 var response = userService.register(user).then(function(results){
				    var respo = results;
				    alert("Successfully Registered!!!!")
				    window.location = "/jQuery/components/profile/profile.template.client.html"
				    $("#username").val('');
				    $("#password").val('');
				    $("#confirm-password").val('');
				    
			 });
		 }
	 }
	 
});