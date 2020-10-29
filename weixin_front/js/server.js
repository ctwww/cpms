var server_url = "http://localhost:8080/BackStage";

//阻止未登录进入
function checklogin(){
	if(!window.sessionStorage["admin_id"]){
		if(!window.sessionStorage["user_id"]){
			window.location.href="index.html";
		}
    }
};

//新增日志
function addJournal(id,illustrate,operation,type){
	var myDate = new Date();
	var date=myDate.toLocaleString(); 
	$.ajax({
		url:server_url + "/addJournal",
		data:{
			id:id,
			illustrate:illustrate,
			date:date,
			operation:operation,
			type:type,
		},
		type:"post",
	});
};
