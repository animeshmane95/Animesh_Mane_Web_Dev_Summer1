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
		
	    
		 var response = userService.findUserbyUserName(userName).then(function(results){
			    var respo = results;
			    if(respo.exists == 'true')
			    	{
			    			$('#submitUser').attr('disabled', true);
			    			alert(" User exists. Submit button is Disabled. Please reload page and try other username");
			    	}
			    
		 });
		 
		
		 		 
	 }
	 
	 function registerUser(){
		 var confirmPassword = $("#confirm-password").val();
		 var password = $("#password").val();
		 var userN = $("#username").val();
		 var user = new User(userN,password,null,null,null,null,null,null);
		 var newUser = userService.register(user)
	 }
	 
});