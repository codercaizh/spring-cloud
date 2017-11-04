$(function(){
	$("#search").click(function(){
		searchContactByName($("#name").val());
	});
	$("#add").click(function(){
		addContact();
	});
	$("#modify").click(function(){
		modifyContact();
	});
	$("#del").click(function(){
		deleteContactByName($("#name").val());
	});
})

function searchContactByName(name){
	clearForm();
	if(name.length == 0){
		alert("姓名不能为空");
		return;
	}
	var url = "/contact/name/" + name;
	var res = $.ajax({url:url,async:false});
	var response = res.responseJSON;
	if(response.rtncode == 0){
		alert("查无此人");
	}else if(response.rtncode == -1){
		alert(response.message);
	}else{
		var contact = response.body;
		$("#id").val(contact.id);
		$("#birthday").val(contact.birthday);
		$("#phone").val(contact.phone);
		$("#wechat").val(contact.wechat);
	}
}

function addContact(){
 	$("#id").val("");
	saveOrUpdateContact();
}

function modifyContact(){
	saveOrUpdateContact();
}

function saveOrUpdateContact(){
	var contactData = $("#contact").serialize();
	var url = "/contact";
	jQuery.post(url,contactData,function(response, textStatus, jqXHR){
		if(response.rtncode == -1){
			alert(response.message);
		}else if(response.rtncode == 0){
			alert("操作失败、该姓名已存在");
		}else{
			var contact = response.body;
			$("#id").val(contact.id);
			alert("操作成功");
		}
	});
}

function deleteContactByName(name){
	var url = "/contact/name/" + name;
	$.ajax({  
        type: 'DELETE',  
        url: url,  
        success: function(response){
        	if(response.rtncode == -1){
    			alert(response.message);
    		}else if(response.rtncode == 0){
    			alert("查无此人");
    		}else{
    			alert("操作成功");
    			clearForm();
    		}
        }
    }); 
}

function clearForm(){
	$("#id").val("");
	$("#birthday").val("");
	$("#phone").val("");
	$("#wechat").val("");
}