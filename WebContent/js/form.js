var emailObj;
var usernameObj;
var passwordObj;
var confirmObj;
var emailMsg;
var usernameMsg;
var passwordMsg;
var confirmMsg;

window.onload=function(){
	emailObj=document.getElementById("email");
	usernameObj=document.getElementById("username");
	passwordObj=document.getElementById("password");
	confirmObj=document.getElementById("repassword");
	emailMsg=document.getElementById("emailMsg");
	usernameMsg=document.getElementById("usernameMsg");
	passwordMsg=document.getElementById("passwordMsg");
	confirmMsg=document.getElementById("confirmMsg");
};
function checkForm(){
	var bEmail=checkEmail();
	var bUsername=checkUsername();
	var bPassword=checkPassword();
	var bConfirm=checkConfirm();

	return bUsername && bPassword && bEmail;
}
function checkEmail(){
	var regex=/^[\w-]+@([\w-]+\.)+[a-zA-z]{2,4}$/;
	var value=emailObj.value;
	var msg="";
	if (!value) 
		msg="邮箱必须填写：";
		else if(!regex.test(value))
			msg="邮箱格式不合法：";
		emailMsg.innerHTML=msg;
		emailObj.parentNode.parentNode.style.color=msg==""?"black":"red";
		return msg=="";
	}
function checkUsername(){
	var regex = /^[a-zA-z_]\w{0,9}$/;
	var value=usernameObj.value;
	var msg = "";
	if (!value) 
		msg="用�名必须填写：";
	else if(!regex.test(value))
		msg="用户名不合法：";
	usernameMsg.innerHTML=msg;
	usernameObj.parentNode.parentNode.style.color=msg==""?"black":"red";
	return msg=="";
}
function checkPassword(){
	var regex = /^.{6,16}$/;
	var value=passwordObj.value;
	var msg="";
	if (!value) 
		msg="密码必须填写：";
	else if(!regex.test(value))
		msg="密码不合法：";
	passwordMsg.innerHTML=msg;
	passwordObj.parentNode.parentNode.style.color=msg==""?"black":"red";
	return msg=="";
}
function checkConfirm(){
	var passwordValue=passwordObj.value;
	var confirmValue=confirmObj.value;
	var msg = "";
	if(!confirmValue){
		msg="确认密码必须填写";
	}else if(passwordValue!=confirmMsg){
		msg="密码必须保持一致"
	}
	confirmMsg.innerHTML=msg;
	confirmObj.parentNode.parentNode.style.color=msg==""?"black":"red";
	return msg=="";
}
