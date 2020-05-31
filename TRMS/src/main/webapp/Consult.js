window.onload= function(){
    console.log("in onload");
    document.getElementById("frSubmitGet").addEventListener("click",getFr,false);
    document.getElementById("SubmitAccept").addEventListener("click",postStatusApprove,false);
    document.getElementById("SubmitDeny").addEventListener("click",postStatusDeny,false);
}

function getFr(){
    console.log("in getFr");
    let frid=document.getElementById("frIDInput").value;
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        console.log( "in ORSC "+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var fr = JSON.parse(xhr.responseText);
            loadFr(fr);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/fr?frid="+frid,true);
    xhr.send();
}

function loadFr(fr){
	
	var d = new Date(fr.dStart);
	fr.dStart = d.toDateString();
	var d2 = new Date(fr.dEnd);
	fr.dEnd = d2.toDateString();
	//var d2 = new Date();
	//dEnd = d2.toDateString();
    document.getElementById("form_id").innerHTML=fr.form_id;
    document.getElementById("emp_name").innerHTML=fr.emp_name;
    document.getElementById("emp_last_name").innerHTML=fr.emp_last_name;
    document.getElementById("location").innerHTML=fr.location;
    document.getElementById("cost_ammount").innerHTML=fr.cost_ammount;
    document.getElementById("dStart").innerHTML=fr.dStart;
    document.getElementById("dEnd").innerHTML=fr.dEnd;
    document.getElementById("type_course").innerHTML=fr.type_course;
    document.getElementById("grade").innerHTML=fr.grade;
    document.getElementById("status").innerHTML=fr.status;
}

/*function jsonBuilder(){
    var elements= document.getElementById("Form").elements;
    var obj={};
    for(var i=0; i<elements.length-1;i++){
        var item=elements.item(i);
        obj[item.name]=item.value;
        console.log(obj);
    }
    var json=JSON.stringify(obj);
    console.log(json);
    return json;
}*/

function postFr(){
    console.log("in postFr");
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        console.log( "in ORSC "+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/TRMS/fr",true);
    var payload=jsonBuilder();
    xhr.send(payload);
}

function postStatusApprove(){
    console.log("in postStatus");
    var formId = document.getElementById("frIDInput").value;
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        console.log( "in ORSC "+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }

    xhr.open("POST","http://localhost:8080/TRMS/Consult?formId="+formId,true);
  
    xhr.send();
}

function postStatusDeny(){
    console.log("in postStatus");
    var formId = document.getElementById("frIDInput").value;
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        console.log( "in ORSC "+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }

    xhr.open("POST","http://localhost:8080/TRMS/deny?formId="+formId,true);
  
    xhr.send();
}