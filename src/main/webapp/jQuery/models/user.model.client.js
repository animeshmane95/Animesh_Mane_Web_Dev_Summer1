function User(username, password, email, firstName, lastName, phone, role, dob) {
this.username = username;
this.password = password;
this.email = email;
this.firstName = firstName;
this.lastName = lastName;
this.phone = phone;
this.role = role;
this.dob = dob;
this.setUsername = setUsername;
this.getUsername = getUsername;
this.setPassword = setPassword;
this.getPassword = getPassword;
this.getEmail = getEmail;
this.setEmail = setEmail;
this.getFirstName= getFirstName;
this.setFirstName = setFirstName;
this.getLastName= getLastName;
this.setLastName = setLasttName;
this.getPhone = getPhone;
this.setPhone = setPhone;
this.getRole = getRole;
this.setRole = setRole;
this.getDOB = getDOB;
this.setDOB = setDOB;

function setUsername(username) {
this.username = username;}

function getUsername() {
return this.username;}

function setPassword(password) {
	this.password = password;}

function getPassword(password) {
	return this.password;}

function setEmail(email) {
	this.email = email;}

function getEmail(email) {
	return this.email;}

function getFirstName(firstname){
	return this.firstname;}

function setFirstName(firstname){
	this.firstname = firstname;}

function getLastName(lastname){
	return this.lastname;}

function setLastName(lastname){
	this.lastname = lasttname;}

function getPhone(phone){
	return this.phone;}

function setPhone(phone){
	this.phone =phone;}

function getRole(role){
	return this.role;}

function setRole(role){
	this.role = role;}

function getDOB(dob){
	return this.dob;}

function setDOB(dob){
	this.dob = dob;}
}