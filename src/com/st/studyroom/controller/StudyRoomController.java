package com.st.studyroom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.common.service.CommonServiceImpl;
import com.st.factory.StudyRoomActionFactory;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.ZipDto;
import com.st.util.NullCheck;
import com.st.util.PageMove;
import com.st.util.StringEncoder;

@WebServlet("/studyroom")
public class StudyRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int spno;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String root = request.getContextPath();
		String act = request.getParameter("act");
		System.out.println("StudyroomController  act === " + act);
		String path = "/main/login.jsp";
		String queryString = "?spno=" + request.getParameter("spno");//�� �����ϰ� �ι�° �� �������� �Ѿ �� ������ �ٿ��� ��
		
		if("rmain".equals(act)) {
			
			path = StudyRoomActionFactory.getStudyRoomListAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvroomrgst".equals(act)) {
			
			path = "/room/roomInfo/register.jsp";
			PageMove.forward(request, response, path);	
			
		} else if("roomrgst".equals(act)) {//
			spno= CommonServiceImpl.getCommonService().selectSPNO();//������Ʈ ��ü�κ��� �޾ƿ��� ���� �ƴ��� ����
			request.setAttribute("roomList",aJaxController.list);	
			request.setAttribute("spno",spno);
			path = StudyRoomActionFactory.getStudyRoomRegisterAction().execute(request, response);	//should check the path first. have to distinguish if user submitted or not  			
			//�� ��� ������ �ݵ�� ���� �ϳ� �̻� ����� ���¿��� �ϹǷ� �ڹٽ�ũ��Ʈ�� ��ȿ�� �˻� �� ��� ��
			
			PageMove.forward(request, response, path);
		} 
		else if("mvrsv".equals(act)) {	
			//���ο��� �� �����ϴ� �������� �Ѿ�
			path = StudyRoomActionFactory.getMoveReservationAction().execute(request, response);
			path += queryString;//�ι�° ���� �������� �Ѿ�� ��.
			PageMove.forward(request, response, path);	
			
		}else if("mvroomrsv".equals(act)) {
			//�� ���� ���������� ��¥�� �����ִ� �������� �Ѿ
			path = StudyRoomActionFactory.getMoveReservationDetailAction().execute(request, response);
			PageMove.forward(request, response, path);		
			
		}else if("roomrsv".equals(act)) {
			path = StudyRoomActionFactory.getStudyRoomReservationAction().execute(request, response);
			PageMove.forward(request, response, path);	
		}else if("mvzip".equals(act)) {
			PageMove.redirect(request, response, "/room/roomInfo/zipsearch.jsp");
			
		}else if("zipsearch".equals(act)){		
			path = StudyRoomActionFactory.getZipsearchAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else {
			PageMove.redirect(request, response, path);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request,response);
		
	}
}