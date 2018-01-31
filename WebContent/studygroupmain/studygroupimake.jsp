<%@page import="java.util.List,com.st.studygroup.model.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>
<script type="text/javascript">
function mvMyGroupContent(SNO){
	document.location.href = "<%=root %>/stgcontroll?act=mvmygroupcontent&SNO="+SNO;
}
</script> 
<%
System.out.println("내가속한그룹이야");
List<StudyGroupDto> list = (List<StudyGroupDto>) request.getAttribute("listmyarticle");
System.out.println(list);
%>
<style>
tr:nth-child(odd){
	background:white;
}

tr:nth-child(even){
	background:lightgray;
}
</style>

<!-- #######################스터디 그룹 리스트 테이블######################### -->
<table class="table  table-hover table-bordered table-sm">
	<thead class="thead-dark">
		<tr>
			<th style="width:110px;">글 번호</th>
			<th>스터디 그룹명</th>
			<th style="width:110px;">그룹장 아이디</th>
			<th style="width:130px;">현재인원/모집인원</th>
			<th style="width:130px;">그룹 상태</th>
		</tr>
	</thead>
	<tbody>
	<%
	int size = list.size();
	if(size != 0){
		for(StudyGroupDto studyGroupDto : list){
	
	%>
		<tr>
			<td><%=studyGroupDto.getSNO()%></td>
			<td><a href="javascript:mvMyGroupContent(<%=studyGroupDto.getSNO()%>);"><%=studyGroupDto.getS_NAME()%></a></td>
			<td><%=studyGroupDto.getS_ID()%></td>
			<td><%=studyGroupDto.getS_PERSON()%>명 / <%=studyGroupDto.getS_MAXPERSON()%>명</td>
			<td><%=studyGroupDto.getS_CURR_STATUS()%> / <%=studyGroupDto.getS_BEING()%></td>
		</tr>
		<%
		}
		}else{
		%>
		<tr>
		<td colspan="5">해당 아이디의 스터디 그룹이 없습니다</td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>



</div>
</div>
</div>

<%@ include file="/common/footer.jsp"%>