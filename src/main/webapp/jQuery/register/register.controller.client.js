$( document ).ready(function() {
 var userService = new UserServiceClient();
	 $(main)
	 
	 
	 function main()
	 {
		 $("#username").blur(findByUserName)
	 }
	 
	 function findByUserName()
	 {
		 var userName = $("#username").val();
		 var response = userService.findUserbyUserName(userName).then(function(results){
			    var respo = results;
			    //alert(respo.exists)
			    
			    if(respo.exists == 'true')
			    	{
			    			alert(" User exists")
			    	}
			    else
			    	{
			    		alert("User does not exists")
			    	}
		 });
		 
		
		 		 
	 }
});