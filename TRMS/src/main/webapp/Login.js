window.onload= function(){
    console.log("in onload Register");
    //document.getElementById("login-form-submit").addEventListener("click",getReg,false);
    document.getElementById("SubmitReg").addEventListener("click",postReg,false);
   
}

//const loginForm = document.getElementById("login-form");
//const loginButton = document.getElementById("login-form-submit");
//const loginErrorMsg = document.getElementById("login-error-msg");



function postReg(){
    console.log("in postReg");
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        console.log( "in ORSC "+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/TRMS/Login",true);
    var payload=jsonBuilder();
    xhr.send(payload);
}