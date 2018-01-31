var root = "/final_studium";
var control = "/stgcontroll";

function movePage(pg, word){
	document.getElementById("cact").value="mvgroup";
	document.getElementById("cpg").value=pg;
	document.getElementById("cword").value=word;
	document.getElementById("commonForm").action= root + control;
	document.getElementById("commonForm").submit();
}

