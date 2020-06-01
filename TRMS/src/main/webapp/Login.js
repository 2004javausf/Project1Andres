window.onload= function(){
    console.log("in onload Register");
    //document.getElementById("login-form-submit").addEventListener("click",getReg,false);
    document.getElementById("SubmitReg").addEventListener("click",postReg,false);
   
}

function jsonBuilder(){
    var elements= document.getElementById("register-form").elements;
    var obj={};
    for(var i=0; i<elements.length-1;i++){
        var item=elements.item(i);
        obj[item.name]=item.value;
        console.log(obj);
    }
    var json=JSON.stringify(obj);
    console.log(json);
    return json;
}


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