<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/studygroupmain/studygroupnav.jsp"%>
		<!--######################### �׺� �Ʒ� ��� ����########################## -->
		<div class="registerback"
			style="background-color: white; overflow: hidden; height: auto; margin-bottom:5%;">
			<!--######################### �׷� ��� ���ø�########################## -->
			<form style="padding: 30px;">
				<fieldset>
					<legend>���͵� �׷��</legend>
					<div class="form-group">
						<label class="col-form-label col-form-label-lg" for="inputLarge">���͵�
							�׷��</label> <input class="form-control form-control-lg" type="text"
							id="inputLarge" readonly="">
					</div>
					<div class="form-group">
						<fieldset>
							<label class="control-label" for="readOnlyInput">���͵� �׷���
								���̵�</label> <input class="form-control" id="readOnlyInput" type="text"
								placeholder="java2" readonly="">
						</fieldset>
					</div>
					<div class="form-group">
						<label for="exampleTextarea">���͵� �׷� �Ұ�</label>
						<textarea class="form-control" id="exampleTextarea" rows="3" readonly=""></textarea>
					</div>
					<div class="form-group">
						<label for="exampleTextarea">#�ؽ��±�</label>
						<textarea class="form-control" id="exampleTextarea" rows="3" readonly=""></textarea>
					</div>
					<div align="center">
						<button type="button" class="btn btn-danger" onclick="location.href='<%=root %>/studygroupmain/studygroupincludeme.jsp'">�ڷΰ���</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</div>


<%@ include file="/common/footer.jsp"%>