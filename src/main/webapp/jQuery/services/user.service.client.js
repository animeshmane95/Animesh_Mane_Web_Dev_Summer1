function UserServiceClient() {
this.createUser = createUser;
this.url = 'http://localhost:8080/api/user';
var self = this;

function createUser(user){
	alert("creating new user in service");
	
	var postObject = {method: 'post',body: JSON.stringify(user),headers: {'content-Type': 'application/json','dataType':'json'} }
	return fetch('/api/user', postObject );
	
	
}


}




