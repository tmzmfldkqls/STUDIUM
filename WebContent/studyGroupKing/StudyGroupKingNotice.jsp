<%@page import="com.st.studygroup.model.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupsubnav.jsp"%>
<%
List<BoardDto> list = (List<BoardDto>) request.getAttribute("enternotice");
%>
<script>
function mvmygroupnoticeregister(){
	document.location.href ="<%=root%>/bc?act=mvmygroupnoticeregister";
}

function mvmygroupnoticecontent(WNO){
	document.location.href ="<%=root%>/bc?act=mvmygroupnoticecontent&WNO=" + WNO;
}

function mygroupnoticecontentdelete(WNO){
	var answer = confirm("정말로 삭제하시겠습니까?")
	if (answer) {
		document.location.href="<%=root%>/bc?act=mygroupnoticecontentdelete&WNO=" + WNO;
	}
	else {
	    return;
	}
	
}

</script>
<div class="notice">
	<table class="table table-striped table-hover table-bordered table-sm">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th></th>
			</tr>
		</thead>
		<%
		int size = list.size();
		if (size != 0) {
			for (BoardDto boardDto : list) {				
		%>
		<tbody>
			<tr>
			<tr>
				<td width="10%"><%=boardDto.getWNO() %></td>
				<td><a href="javascript:mvmygroupnoticecontent('<%=boardDto.getWNO() %>');"><%=boardDto.getW_TITLE() %></a></td>
				<td width="10%"><%=boardDto.getW_ID() %></td>
				<td width="10%"><%=boardDto.getW_DATE() %></td>
				<td width="5%"><button type="button" class="btn btn-danger"	
				onclick="javascript:mygroupnoticecontentdelete('<%=boardDto.getWNO() %>');">삭제</button></td>
			</tr>
		</tbody>
		<%
			}
		} else {
		%>
		<tbody>
		<tr>
			<td colspan="4">작성된 공지사항이 없습니다</td>
		</tr>
		</tbody>
		<%
			}
			
		%>
	</table>
</div>
<div align="center" style="margin-bottom: 2%;">
	<button type="button" class="btn btn-success"
		onclick="javascript:mvmygroupnoticeregister();">등록</button>
	
</div>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>