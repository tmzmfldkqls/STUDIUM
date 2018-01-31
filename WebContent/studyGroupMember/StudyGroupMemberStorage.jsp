<%@page import="com.st.studygroup.model.BbsGroupDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupmembersubnav.jsp"%>
<%
List<BbsGroupDto> list = (List<BbsGroupDto>) request.getAttribute("bbsList");
%>
<div class="storage">
	<table class="table table-striped table-hover table-bordered table-sm">
		<thead>
			<tr>
				<th>아이디</th>
				<th>파일이름</th>
				<th>파일내용</th>
				<th>다운로드</th>
				<th>업로드된시간</th>
			</tr>
		</thead>
		<%
	int size = list.size();
	if(size != 0){
		for(BbsGroupDto bbsGroupDto : list){
	%>
		<tbody>
			<tr>
				<td><%=bbsGroupDto.getF_ID()%></td>
				<td><%=bbsGroupDto.getF_NAME()%></td>
				<td><%=bbsGroupDto.getF_CONTENT()%></td>
				
				<td>
				<a href="<%= root %>/fileDownload?fileName=<%=bbsGroupDto.getF_NAME()%>"><button type="button" class="btn btn-success"
						style="float: middle;">다운로드</button></a></td>
				<td>
				<div class="progress">
						<div class="progress-bar progress-bar-striped progress-bar-animated"
							role="progressbar" aria-valuenow="75" aria-valuemin="0"
							aria-valuemax="100" style="width: 75%"></div>
					</div></td>
			</tr>
		</tbody>

		<%
		}
	}else{
		%>
		<tr>
			<td colspan="5">등록된 자료가 없습니다.</td>
		</tr>
		<%
	}
		%>
	</table>
</div>
</div>
</div>
</div>
<%@include file="/common/footer.jsp"%>