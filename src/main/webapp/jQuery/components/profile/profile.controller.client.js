$( document ).ready(function() {
 var userService = new UserServiceClient();
 $(main);
 
 function main(){	 
	 getProfileData();
	 
	 }
 
 function updateProfile(user){
	var username =  $("#username").val();
	var password = $("#password").val();
	var email = $("#email").val();
	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();
	var phone = $("#phone").val()
	var role = $("#Role").val();
	var dob  = $("#dob").val();
	
	var updatedUser = new User(username,password,email,firstName,lastName,phone,role,dob);
	 var response = userService.updateProfile(updatedUser).then(function(results){
		    var respo = results;
		    alert("Successfully Updated")
		    
	 });

	 
 }


function getProfileData(){
	
	var currentUser = userService.getProfile().then(function(results){
		var Result = results;
		 $("#username").val(Result.username);
		 $("#password").val(Result.password);
		 $("#email").val(Result.email);
		 $("#firstName").val(Result.firstName);
		 $("#lastName").val(Result.lastName);
		 $("#phone").val(Result.phone)
		 $("#Role").val(Result.role);
		 $("#dob").val(Result.dob);
		 
		 $(document).on('click','#profile-update',function(){updateProfile(Result);});
		  $(document).on('click','#logout',function(){
			  
			  var user = userService.logout(Result);
			  if(user.id != Result.username)
				  {
				  	
				    window.location.replace("../login/login.template.client.html");
				  }
			  
		  });
	});
}
  

	 
});