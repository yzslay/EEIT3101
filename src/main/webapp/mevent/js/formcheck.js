document.getElementById("file1").addEventListener("change",fileviewer);
$("input#name").blur(check);
$("input[type='date']").blur(check);
$("input[type='time']").blur(check);
$("#btn").click(submit);

function fileviewer() {
	let reader = new FileReader();
	reader.addEventListener("load", function (e) {
	let fileContent = e.target.result;
	let show = document.getElementById("img1");
	show.setAttribute("src", fileContent);
	})
	let file = document.getElementById("file1").files[0];
	reader.readAsDataURL(file);
}

function check(){
	let Val = $(this).val();
	if (Val == "") {
		$(this).next().css("color","red").append("<b>╳不可空白</b>")
	}else{
		$(this).next().empty();
	}
}

function submit(){
	if($("input#name").val()=="" || $("#spsd").prev().val()=="" || $("#spst").prev().val()=="" || $("#sped").prev().val()=="" || $("#spet").prev().val()==""){
		alert("活動名稱、活動開始時間、活動結束時間，不可空白");				
	}else{
		$("form").submit();}
}


function dataURItoBlob(dataURI) {
    // convert base64/URLEncoded data component to raw binary data held in a string
    var byteString;
    if (dataURI.split(',')[0].indexOf('base64') >= 0)
        byteString = atob(dataURI.split(',')[1]);
    else
        byteString = unescape(dataURI.split(',')[1]);

    // separate out the mime component
    var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];

    // write the bytes of the string to a typed array
    var ia = new Uint8Array(byteString.length);
    for (var i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }

    return new Blob([ia], {type:mimeString});
}