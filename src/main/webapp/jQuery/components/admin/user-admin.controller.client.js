$(document).ready(function(){
	var userName; 
	var password ; 
	var email ;
	var firstName;
	var lastName;
	var phone;
	var role;
	var dob;
	var template;
	var tbody;
	var clientService = new UserServiceClient;
	var userId;
	$(document).ready(main);

	function main(){
		findAllUsers();
		$("#button3").hide();
		 tbody = $('tbody');
		 template = $('.template');
		$("#button2").click(createUser);
		$(document).on('click','#button5',function(){findUserById(this);});
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

	
	clientService.createUser(newUser, findAllUsers);
	 alert('Successfully Created!!!!!')
	  $("#usernameFld").val('');
	 $("#passwordFld").val('');
	  $("#emailFld").val('');
	  $("#firstNameFld").val('');
	  $("#lastNameFld").val('');
	  $("#PhoneFld").val('');
	  $("#roleFld").val('');
	  $("#DOBFld").val('');
	}
	
	 function findAllUsers() {
		
	     clientService.findAllUsers().then(renderUsers);
	    }
	 
	 function renderUsers(users) {
		
		 tbody.empty();
	        for(var i=0; i<users.length; i++) {
	            var user = users[i];
	            var clone = template.clone();
	            clone.attr('id', user.id);
	            clone.find('.delete').click(deleteUser);
	            clone.find('.edit').click(editUser);
	            clone.find('.username').html(user.username);
	            clone.find('.password').html(user.password);
	            clone.find('.email').html(user.email);
	            clone.find('.fname').html(user.firstName);
	            clone.find('.lname').html(user.lastName);
	            clone.find('.phone').html(user.phone);
	            clone.find('.role').html(user.role);
	            clone.find('.dob').html(user.dob);
	            tbody.append(clone);
	        }
	    }
	 
	  function deleteUser(event) {
	        var deleteBtn = $(event.currentTarget);
	        var userId = deleteBtn.parent().parent().attr('id');

	        clientService.deleteUser(userId);}
	  function editUser(event) {
	        console.log('editUser');
	        console.log(event);}
	  
	  function findUserById(obj){
		 var td =  $(obj).closest('tr').find('td');
		 var userId =  $(obj).closest('tr').attr('id');
		 alert("Hello");
		 var retirvedUser = new User(userName,password,email,firstName,lastName,phone,role,dob);
		 clientService.findUserById(userId).then(renderUser);
	  }
	  
	  function renderUser(user){
		  $("#usernameFld").val(user.username);
		  $("#passwordFld").val(user.password);
		  $("#emailFld").val(user.email);
		  $("#firstNameFld").val(user.firstName);
		  $("#lastNameFld").val(user.lastName);
		  $("#PhoneFld").val(user.phone);
		  $("#roleFld").val(user.role);
		  $("#DOBFld").val(user.dob);
		  $("#button2").hide();
		  $("#button3").show();
		  alert("After changing values please click on update button")
		  $(document).on('click','#button3',function(){updateUser(user);});
	  }
	  
	  function updateUser(user){
		  user.password = $("#passwordFld").val();
		  user.email = $("#emailFld").val();
		  user.firstName = $("#firstNameFld").val();
		  user.lastName = $("#lastNameFld").val();
		  user.phone = $("#PhoneFld").val();
		  user.role = $("#roleFld").val();
		  user.dob = $("#DOBFld").val();
		  clientService.updateUser(user,user.id,findAllUsers);
		  alert("Successfully Updated!!!!!")
		  $("#usernameFld").val('');
			 $("#passwordFld").val('');
			  $("#emailFld").val('');
			  $("#firstNameFld").val('');
			  $("#lastNameFld").val('');
			  $("#PhoneFld").val('');
			  $("#roleFld").val('');
			  $("#DOBFld").val('');
			  $("#button3").hide();
			  $("#button2").show();
	  }
	  
	    function deleteUser(event) {
	    	
	        var deleteBtn = $(event.currentTarget);
	        var userId = deleteBtn
	            .parent()
	            .parent()
	            .attr('id');

	        clientService.deleteUser(userId,findAllUsers);
	        alert('Successfully Deleted!!!!!')
	        
	    }

});





