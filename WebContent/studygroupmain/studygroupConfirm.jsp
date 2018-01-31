<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>
		<!--######################### 네비 아래 흰색 바탕########################## -->
		<div class="registerback"
			style="background-color: white; overflow: hidden; height: auto; margin-bottom:5%;">
			<!--######################### 그룹 등록 템플릿########################## -->
			<form style="padding: 30px;">
				<fieldset>
					<legend>스터디 그룹명</legend>
					<div class="form-group">
						<label class="col-form-label col-form-label-lg" for="inputLarge">스터디
							그룹명</label> <input class="form-control form-control-lg" type="text"
							id="inputLarge" readonly="">
					</div>
					<div class="form-group">
						<fieldset>
							<label class="control-label" for="readOnlyInput">스터디 그룹장
								아이디</label> <input class="form-control" id="readOnlyInput" type="text"
								placeholder="java2" readonly="">
						</fieldset>
					</div>
					<div class="form-group">
						<label for="exampleTextarea">스터디 그룹 소개</label>
						<textarea class="form-control" id="exampleTextarea" rows="3" readonly=""></textarea>
					</div>
					<div class="form-group">
						<label for="exampleTextarea">#해쉬태그</label>
						<textarea class="form-control" id="exampleTextarea" rows="3" readonly=""></textarea>
					</div>
					<div align="center">
						<button type="button" class="btn btn-danger" onclick="location.href='<%=root %>/studygroupmain/studygroupincludeme.jsp'">뒤로가기</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</div>


<%@ include file="/common/footer.jsp"%>