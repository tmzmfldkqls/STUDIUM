package com.st.studyroom.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.st.common.service.CommonServiceImpl;
import com.st.factory.StudyRoomActionFactory;
import com.st.member.model.MemberDto;
import com.st.studyroom.model.RmAlbDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.service.StudyRoomServiceImpl;
import com.st.util.BoardConstance;
import com.st.util.PageMove;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String realPath;
	private int maxSize;
	private String encoding;
	String path = "/main/login.jsp";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		realPath = config.getServletContext().getRealPath("/room/upload");
		maxSize = 3 * 1024 * 1024;//3Mb
		encoding = BoardConstance.MAIN_ENCODING;
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		int spno = (int)StudyRoomController.spno;
		int cnt1 = 0, cnt2=0;
		
		if(memberDto != null) {
			if(spno != 0) {
				String saveDirectory = realPath +File.separator + Integer.toString(memberDto.getMNO());
						
				File file = new File(saveDirectory);
				if(!file.exists())
					file.mkdirs();
				MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxSize, encoding, new DefaultFileRenamePolicy());

				//��ǥ�̹����� dto �ϳ� ����
				RmAlbDto rmAlbDto = new RmAlbDto();
				//rmAlbDto.setINO(iNO);�̰� ���ܿ��� �ؽ�Ʈ�� ���ٰ�
				rmAlbDto.setSPNO(spno);//�̰� �׳� ������ȣ��
				rmAlbDto.setI_STATUS("1");//�������� �ϴ� ������
				rmAlbDto.setSAVEFOLDER(Integer.toString(memberDto.getMNO()));
				rmAlbDto.setORIGIN_IMG(multi.getFilesystemName("sp_img"));
				rmAlbDto.setSAVE_IMG(multi.getFilesystemName("sp_img"));
				cnt1 = StudyRoomServiceImpl.getStudyRoomService().imgRegister(rmAlbDto);
				
				//�� �̹����� ��Ƽ�� ����
				List<RmAlbDto> list = new ArrayList<RmAlbDto>();
				
				Enumeration  files = multi.getFileNames();
				while(files.hasMoreElements()){
					String filenames = (String) files.nextElement();
					//���̹����� dto ����
					RmAlbDto detailrmAlbDto = new RmAlbDto();
					//rmAlbDto.setINO(iNO);�̰� ���ܿ��� �ؽ�Ʈ�� ���ٰ�
					detailrmAlbDto.setSPNO(spno);//�̰� �׳� ������ȣ��
					detailrmAlbDto.setI_STATUS("");//�������� �ϴ� ������
					detailrmAlbDto.setSAVEFOLDER(Integer.toString(memberDto.getMNO()));
					detailrmAlbDto.setORIGIN_IMG(multi.getFilesystemName(filenames));
					detailrmAlbDto.setSAVE_IMG(multi.getFilesystemName(filenames));
					list.add(detailrmAlbDto);
				}
				cnt2 = StudyRoomServiceImpl.getStudyRoomService().imgListRegister(list);
				
				}
			if(cnt1*cnt2 != 0)
				path = "main/main.jsp";
			} 
		
		PageMove.forward(request, response, path);
		}
	}
	

