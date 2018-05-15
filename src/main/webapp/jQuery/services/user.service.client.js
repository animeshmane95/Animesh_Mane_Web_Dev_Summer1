function UserServiceClient() {
this.createUser = createUser;
this.findAllUsers = findAllUsers;
this.findUserById = findUserById;
this.updateUser = updateUser;
this.deleteUser = deleteUser;
this.findUserbyUserName = findUserbyUserName;
this.login = login
this.register = register
this.url = '/api/user';
this.url1 = '/api/register'
this.url2 = '/api/login'
var self = this;

function login(user){
	var postObject = {method: 'post',body: JSON.stringify(user),headers: {'content-Type': 'application/json','dataType':'json'} }
	return fetch(self.url2, postObject).then(function (response) {return response.json();});
}

function register(user){
	var postObject = {method: 'post',body: JSON.stringify(user),headers: {'content-Type': 'application/json','dataType':'json'} }
	fetch('/api/register', postObject).then(function (response) {return response.json();});
}

function findUserbyUserName(username){
	return fetch(self.url1 + "/" + username).then(function (response) {return response.json();});
}


function createUser(user,callback){
	var postObject = {method: 'post',body: JSON.stringify(user),headers: {'content-Type': 'application/json','dataType':'json'} }
	fetch('/api/user', postObject ).then(callback);
}


function findAllUsers() {
    return fetch(self.url)
        .then(function (response) {
            return response.json();
        });}

function findUserById(userId){
	return fetch(self.url + '/findUserById?userId=' + userId).then(function (response) {return response.json();});


}

function updateUser(user,userid,callback){
	var postObject = {method: 'put',body: JSON.stringify(user),headers: {'content-Type': 'application/json','dataType':'json'} }
	return fetch('/api/user/' + userid, postObject ).then(callback);}

function deleteUser(userId,callback) {
    return fetch(self.url + '/' + userId, {
        method: 'delete'
    }).then(callback)}


}