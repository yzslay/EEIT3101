$(document).ready(function(){
	$("#deldiv").dialog({
		autoOpen:false,
		resizable:false,
		height:"auto",
		width:400,
		modal:true
	});
});

$(".w3-button.del").click(function(e){
	e.preventDefault();
	var targetUrl=$(this).attr("href");
	
	$("#deldiv").dialog({
		buttons : {
			"確定" : function(){
				window.location.href = targetUrl;
			},
			"取消" : function(){
				$(this).dialog("close");
			}
		}
	});
	
	$("#deldiv").dialog("open");
});




	