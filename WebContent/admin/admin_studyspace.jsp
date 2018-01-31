<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/admin_header.jsp"%>
<link rel="stylesheet" href="<%=root%>/css/sb-admin-2.css">
<script type="text/javascript" src="<%= root %>/js/httpRequest.js"></script>
<script type="text/javascript">
window.onload = function() {
	spacelist();
}
function spacelist() {
	var key = document.getElementById("key").value;
	var word = document.getElementById("word").value;
	var params = "act=spacelist&key=" + key + "&word=" + word;
	sendRequest("<%= root%>/admin", params, viewlist, "GET");
}
function viewlist() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			var listxml = httpRequest.responseXML; // mlist�޾ƿ�
			makelist(listxml);
		}
	}
}
function makelist(listxml) {
	var tbody = document.getElementById("slist");
	
	removeTbody(tbody);
	var len = listxml.getElementsByTagName("space").length;
	for(var i=0; i<len; i++) {
		var row = makerow(listxml.getElementsByTagName("space")[i]);		
		tbody.appendChild(row);
	}
}
function makerow(member) {
	
	var spno = member.getElementsByTagName("spno")[0].firstChild.data	
	var name = member.getElementsByTagName("name")[0].firstChild.data;
	var scontent = member.getElementsByTagName("scontent")[0].firstChild.data;
	var tag = member.getElementsByTagName("tag")[0].firstChild.data;
	var web = member.getElementsByTagName("web")[0].firstChild.data;
	var status = member.getElementsByTagName("status")[0].firstChild.data;
	var cel1 = makecell(spno,"spno");
	var cel2 = makecell(name,"name");
	var cel3 = makecell(scontent,"scontent");
	var cel4 = makecell(tag,"tag");
	var cel5 = makecell(web,"web");
	var cel6 = makecell(status,"status");
	var row = document.createElement("tr");
	row.appendChild(cel1);
	row.appendChild(cel2);
	row.appendChild(cel3);
	row.appendChild(cel4);
	row.appendChild(cel5);
	row.appendChild(cel6);
	
	return row;
	
}
function makecell(data,tag) {
	var td = document.createElement("td");
	var txtNode = document.createTextNode(data);	
	if(tag == "status") {
		var select = document.createElement("select");
		select.setAttribute("onchange", "javascript:statusChange(this)");
		select.setAttribute("id", "status");
		select.setAttribute("name", "status");
		var option = document.createElement("option");
		var option1 = document.createElement("option");
		if(txtNode.nodeValue == '�����'){
			option.setAttribute("selected", "selected");
		}else if(txtNode.nodeValue == '����'){
			option1.setAttribute("selected", "selected");
		}
		select.appendChild(option);
		option.setAttribute("value", "1");		
		option.appendChild(document.createTextNode("�����"));
		select.appendChild(option1);
		option1.setAttribute("value", "0");
		option1.appendChild(document.createTextNode("����"));	
		td.appendChild(select);
	}else if(tag == "tag"){
		var input = document.createElement("input");
		input.setAttribute("onkeyup", "if(event.keyCode == 13){changetag(this);}");
		input.setAttribute("type", "text");
		input.setAttribute("size", "35");
		input.setAttribute("value", txtNode.nodeValue);
		td.appendChild(input);
	}else {
		td.appendChild(txtNode);
	}
	return td;
}

function changetag(obj) {
	var tr = $(obj).parent().parent();
	var td = tr.children();
	var spno = td.eq(0).text();
	var tag = obj.value;		
	var params = "act=changetag&num="+spno+"&no=spno&tag="+encodeURL(tag);
	sendRequest("<%=root%>/admin", params, spacelist, "GET");
}
function encodeURL(str){
var s0, i, s, u;
s0 = "";               // encoded str
for (i = 0; i < str.length; i++){   // scan the source
    s = str.charAt(i);
    u = str.charCodeAt(i);         // get unicode of the char
    if (s == " "){s0 += "+";}       // SP should be converted to "+"
    else {
        if ( u == 0x2a || u == 0x2d || u == 0x2e || u == 0x5f || ((u >= 0x30) && (u <= 0x39)) || ((u >= 0x41) && (u <= 0x5a)) || ((u >= 0x61) && (u <= 0x7a))){       // check for escape
            s0 = s0 + s;            // don't escape
        }
        else {                  // escape
            if ((u >= 0x0) && (u <= 0x7f)){     // single byte format
                s = "0"+u.toString(16);
                s0 += "%"+ s.substr(s.length-2);
            }
            else if (u > 0x1fffff){     // quaternary byte format (extended)
                s0 += "%" + (oxf0 + ((u & 0x1c0000) >> 18)).toString(16);
                s0 += "%" + (0x80 + ((u & 0x3f000) >> 12)).toString(16);
                s0 += "%" + (0x80 + ((u & 0xfc0) >> 6)).toString(16);
                s0 += "%" + (0x80 + (u & 0x3f)).toString(16);
            }

            else if (u > 0x7ff){        // triple byte format
                s0 += "%" + (0xe0 + ((u & 0xf000) >> 12)).toString(16);
                s0 += "%" + (0x80 + ((u & 0xfc0) >> 6)).toString(16);
                s0 += "%" + (0x80 + (u & 0x3f)).toString(16);
            } else {                      // double byte format
                s0 += "%" + (0xc0 + ((u & 0x7c0) >> 6)).toString(16);
                s0 += "%" + (0x80 + (u & 0x3f)).toString(16);
            }
        }
    }
}
return s0;
}
function statusChange(obj){
   var tr = $(obj).parent().parent();
   var td = tr.children();
   var spno = td.eq(0).text();
   var stat = obj.value;
   var params = "act=changestat&num="+spno+"&stat="+stat+"&no=spno";
   sendRequest("<%=root%>/admin", params, spacelist, "GET");
}



function removeTbody(tbody) {
	var len = tbody.childNodes.length;
	for(var i=len-1; i>=0; i--) {
		tbody.removeChild(tbody.childNodes[i]);
	}
}
</script>
<div id="wrapper">


	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12 pt-4">
				<h1 class="page-header"></h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">���͵��������
					<div align="right">
					<select id="key">
					<option value="sp_name">���� �̸�</option>
					<option value="sp_tag">���� �ױ�</option>
					<option value="sp_web">������Ʈ</option>
					</select>
					<input type="text" id="word" name="word">
					<input type="button" value="�˻�" onclick="javascript:spacelist();">	
					</div>
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<table class="table  table-hover table-bordered table-sm">
							<thead class="thead-dark">
								<tr>
									<th style="width: 80px;">���� ��ȣ</th>
									<th style="width: 100px;">���� �̸�</th>
									<th style="width: 400px;">������ ����</th>
									<th style="width: 100px;">���� �ױ�</th>	
									<th style="width: 150px;">������Ʈ</th>
									<th style="width: 80px;">���� ����</th>
								</tr>
							</thead>
							<tbody id="slist"></tbody>
						</table>
					</div>
					<!-- .panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-6 -->

		</div>
		<!-- /#page-wrapper -->

	</div>


<%@ include file="/common/admin_footer.jsp" %>