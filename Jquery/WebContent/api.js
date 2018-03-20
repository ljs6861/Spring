function mInsert(){
		var fdata=$("#frm").serialize();
		$.ajax({
			url: "mInsert.do", //MemberInsertListController.java
			type: "post",
			data: fdata,
			success : mlist,
			error : function(){ alert("저장실패");}
		});
	}
	
	function mlist(){
		$("#rebtn").trigger("click");
		$.ajax({
			url : "mlist.do", // MemberListController.java
			type: "get",
			dataType : "json",
			success: resultHtml, //callback
			error : function(){ alert("error")}
		});
	}

	function resultHtml(data){
		//alert(data);
		
		
	
		var html="<table border='1' width='500px'>";
		
	
		html+="<tr bgColor='gray' align='center'>";
		html+="<td>번호</td>";
		html+="<td>이름</td>";
		html+="<td>나이</td>";
		html+="<td>이메일</td>";
		html+="<td>자기소개</td>";
		html+="<td>삭제</td>";
		html+="<td>수정</td>";
		html+="</tr>";
		
		$.each(data,function(index, obj){
			
			html+="<tr>";
			html+="<td id='num"+index+"'>"+obj.num+"</td>";
			html+="<td id='irum"+index+"'>"+obj.irum+"</td>";
			html+="<td id='age"+index+"'>"+obj.age+"</td>";
			html+="<td id='email"+index+"'>"+obj.email+"</td>";
			html+="<td id='intro"+index+"'>"+obj.intro+"</td>";
			
			html+="<td><button onClick ='mDelete("+obj.num+")'>삭제</button>/</td>";
			html+="<td><button onClick ='mUpdate("+index+")'>수정</button>/</td>";
			html+="</tr>";
			
		});
		
		
		html+="</table>";
		
		$("#msg").empty();
		$("#msg").append(html);
	}
	
	function mUpdate(index){
		var num= $("#num"+index).text();
		var irum= $("#irum"+index).text();
		var age= $("#age"+index).text();
		var email= $("#email"+index).text();
		var intro= $("#intro"+index).text();
		//alert(num+":"+intro);
		$("#num").val(num);
		$("#age").val(age);
		$("#email").val(email);
		$("#intro").val(intro);
		$("#inup").empty(); //가입버튼이 수정버튼으로 바뀜, 
		$("#inup").append("<input type='button' value='수정' id='upbtn'/>");
		$("#upbtn").click(mUpdateGo);

	}
	
	function mUpdateGo(){
		var fdata=$("#frm").serialize();

	$.ajax({
		url: "mUpdate.do",
		type: "post",
		data: fdata,
		success : mlist,
		error: function(){ alert("error");}
		
	});
	
	$("#inup").empty();
	$("#inup").html("<input type='button' value='가입' id='btn'/>");
	$("#btn").click(mInsert);
	$("#rebtn").trigger("click");
	
	
	
	}
	
	
	
	function mDelete(num){
		//alert(num);
		$.ajax({
			url : "mDelete.do", // MemberDeleteController.java
			type : "get", // 하나만 넘기니까
			data : { "num" : num}, // num=10
			success : mlist,
			error : function(){ alert("error");}
		});
	}