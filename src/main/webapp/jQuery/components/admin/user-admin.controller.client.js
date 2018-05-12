var userName  = $("username Fld").html
var password  = $("password Fld").html
var email     = $("email Fld").html
var firstName = $("firstName Fld").html
var lastName  = $("lastName Fld").html
var phone     = $("Phone Fld").html
var role      = $("role Fld").html
var dob       = $("DOB Fld").html

$(document).ready(function clickEvents(){
	$("#div1").hide();
    $("#div2").hide();
    $("#div3").hide();
    $("#div4").hide();
    $("#div5").hide();
    $(main);
});
function main(){
	 $("#button1").click(displayCreateUser);
	 $("#button2").click(findAllUsers);
	 $("#button3").click(retrieveUserForEditing);
	 $("#button4").click(editDeleteUser);
	 $("#button5").click(findUserById);
	 $("#button6").click(createUser);
	 $("#button7").click(updateUser);}

function createUser(){
var newUser = new User(usernmane,password,email,firstName,lastName,phone,role,dob);
}
	
//Function to execute click event when Create User button is clicked
function displayCreateUser(){   
    var $patt = $("#div5").attr("style");
   	var $match= $patt.match(/display: none;/g); 	
     if($("#div2").attr("style")==!("display: none;")){
     	$("#div2").hide();}
     if($("#div3").attr("style")==!("display: none;")){
     	$("#div3").hide();}
     if($("#div4").attr("style")==!("display: none;")) {
     	$("#div4").hide();}
     if($match==null){
     	$("#div5").hide();}
     if($("#div1").attr("style")==!("display: none;")){
     	$("#div1").hide(); }
     else{
     	$("#div1").show();}
}

//Function to execute click event when 'Retrieve All Users'button is clicked
function findAllUsers(){
    var $patt = $("#div5").attr("style");
   	var $match= $patt.match(/display: none;/g);   	
     if($("#div1").attr("style")==!("display: none;")){
     	$("#div1").hide();}
     if($("#div3").attr("style")==!("display: none;")){
     	$("#div3").hide();}
     if($("#div4").attr("style")==!("display: none;")){
     	$("#div4").hide();}
     if($match==null){
     	$("#div5").hide();}
     if($("#div2").attr("style")==!("display: none;")){
     	$("#div2").hide();}
     else{
     	$("#div2").show();}
     }

function retrieveUserForEditing(){
	var $patt = $("#div5").attr("style");
   	var $match= $patt.match(/display: none;/g); 	
	if($("#div1").attr("style")==!("display: none;")){
    	$("#div1").hide();}
	if($("#div2").attr("style")==!("display: none;")){
    	$("#div2").hide();}
	if($("#div3").attr("style")==!("display: none;")){
    	$("#div3").hide();}
	if($("#div4").attr("style")==!("display: none;")){
     	$("#div4").hide();}
   	if($match==null){
    	$("#div5").hide();}
    else{
    	$("#div5").show();}
   	}

function editDeleteUser(){
	var $patt = $("#div5").attr("style");
    var $match= $patt.match(/display: none;/g);	
 	if($("#div1").attr("style")==!("display: none;")){
     	$("#div1").hide();}
 	if($("#div2").attr("style")==!("display: none;")){
     	$("#div2").hide();}
 	if($("#div4").attr("style")==!("display: none;")){
      	$("#div4").hide();}	
    if($match==null){
     	$("#div5").hide();
     }
    if($("#div3").attr("style")==!("display: none;")){
     	$("#div3").hide();
     }
   else{
     	$("#div3").show();}
}

function findUserById(){
    var $patt = $("#div5").attr("style");
   	var $match= $patt.match(/display: none;/g);
   	
	if($("#div1").attr("style")==!("display: none;")){
    	$("#div1").hide();}
	if($("#div2").attr("style")==!("display: none;")){
    	$("#div2").hide();}
	if($("#div3").attr("style")==!("display: none;")){
     	$("#div3").hide();}
   	 $("#div4").show();}