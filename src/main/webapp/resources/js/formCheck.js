/**
 * 
 */
function loginFormCheck(){
	
	if(document.forms["login"]["pw"].value< 4){
		document.getElementById("login_error").innerText = "비밀번호를 확인하세요"
		document.forms["login"]["pw"].focus();
		
		return false;
	}
	
}

function memberFormCheck(){


//	아이디 중복시 커서 이동
	if(document.getElementById("isidCheck").value == 1){
		document.getElementById("id_input").focus();
//		document.forms["memReg"]["id"].focus();
//		document.querySelector("#id_input").focus();
		return false;	
	}
	
	
	
//	비밀번호
	var pw = document.forms["memReg"]["pw"].value;
	if(pw.length <4){
		document.getElementById("pw_error").innerText="너무 짧습니다.";
		
		return false;
	}
//	이메일
	if(document.forms["memReg"]["eid"].value == "" && document.forms["memReg"]["domain"].value !=0){
		document.getElementById("eid_error").innerText="이메일을 입력해 주세요."
		
		return false;
		}
	if(document.forms["memReg"]["gender"].value ==""){
		
		document.getElementById("gender_error").innerText = "성별을 체크하세요"
		return false;
	}
//	취미
	var hobby_length = document.forms["memReg"]["hobby"].length;
	console.log("취미개수 : " + hobby_length)
	var count = 0;
	
	for(i=0; i<3; i++){
//		console.log("변수 i 값 :" + i);
		if(document.forms["memReg"]["hobby"][i].checked){
			count++
			break;
		}
	}
	if(count==0){
		document.getElementById("hobby_error").innerText = "취미를 체크하세요"
		return false;
	}
		
	
}

function inputdomain(){
	
	var sel = document.forms["memReg"]["sel_domain"].value;
	
	document.forms["memReg"]["domain"].value=sel;
	
	if(sel != ""){
		document.forms["memReg"]["domain"].readOnly = true;		
	}
	else{
		document.forms["memReg"]["domain"].readOnly = false;	
	}
	
}


function idCheck(){
	var id =document.forms["memReg"]["id"].value;
	
	if(id.length == 0){
		alert('아이디를 입력해라');
		return;
	}	
	
	var x = new XMLHttpRequest();
	
	x.onreadystatechange = function(){
		if(x.readyState === 4){
			
			if(x.status === 200){
//				alert(x.responseText.trim())
				var msg = document.getElementById("idCheckMsg");
				
//	아이디 중복된 경우 체크				
				document.getElementById("isidCheck").value=x.responseText.trim();
						
				if(x.responseText.trim() =="0"){
					msg.innerText = "사용가능하다";
				}
				
				else{
					msg.innerText = "중복이다 바꿔";
				}
								
			}else{
				console.log('에러코드 : '+ x.status);
			}
			
		}
		
	};

//	get방식	
//	x.open("get",root_path + "/idCheck.jsp?id=" + id, true);
//	x.send();

//	post방식
	x.open("POST","/member/idDoubleCheck", true);
	x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	x.send("id=" + id);
}



