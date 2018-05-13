function UserServiceClient() {
this.createUser = createUser;
this.findAllUsers = findAllUsers;
this.findUserById = findUserById;
this.updateUser = updateUser;
this.deleteUser = deleteUser;
this.url = 'http://localhost:8080/api/user';
var self = this;

function createUser(user){
	var postObject = {method: 'post',body: JSON.stringify(user),headers: {'content-Type': 'application/json','dataType':'json'} }
	return fetch('/api/user', postObject );
}


function findAllUsers() {
    return fetch(self.url)
        .then(function (response) {
            return response.json();
        });}

function findUserById(userId){
	return fetch(self.url + '/findUserById?userId=' + userId).then(function (response) {return response.json();});


}

function updateUser(user,userid){
	var postObject = {method: 'put',body: JSON.stringify(user),headers: {'content-Type': 'application/json','dataType':'json'} }
	return fetch('/api/user/' + userid, postObject );}

function deleteUser(userId) {
    return fetch(self.url + '/' + userId, {
        method: 'delete'
    })}

}