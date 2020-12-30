/**
 * 
 */
 $(function() {
	$("#post").click(function(){
		//보낼 데이터 가져오기
		let id = $("#id").val();
		let age = $("#age").val();
	
		$.ajax({
			type:"post",
			url:"sendForm.jsp",
			data:{
				id:id,
				age:age
			},
			success:function(data){
				$("#ajaxReturn").html(data);
			},
			error:function(xhr,txtStatus,error){
				alert("error");
			}
		})
	}); 
 });
function postSend() {
	//보낼 데이터 가져오기
	let id = document.getElementById("id").value;
	let age = document.getElementById("age").value;
	
	let httpRequest = new XMLHttpRequest();
	httpRequest.open('Post','agetAjax.jsp');
	httpRequest.setRequestHeader('Content-type','application/x-mm-form-urlencoded');
	httpRequest.send('id='+id+'&age='+age);
}