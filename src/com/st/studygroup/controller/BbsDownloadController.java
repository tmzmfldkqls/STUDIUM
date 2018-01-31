package com.st.studygroup.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BbsGroupDto;
import com.st.studygroup.service.BbsServiceImpl;
import com.st.util.BoardConstance;
import com.st.util.PageMove;
import com.st.util.StringEncoder;


@WebServlet("/fileDownload")
public class BbsDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String realPath;
	private int maxSize;
	private String encoding;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		realPath = config.getServletContext().getRealPath("/upload");
		maxSize = 1000 * 1024 * 1024; // 1GB
		encoding = BoardConstance.MAIN_ENCODING;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
				String saveDirectory = realPath;// 파일구분자를 알아서 나눠준다
				
				String fileName = StringEncoder.isoToEuc(request.getParameter("fileName"));
				BbsGroupDto bbsGroupDto = BbsServiceImpl.getBbsService().downLoad(fileName);
				File realFile = new File(saveDirectory + "/" + fileName);
				// ④ 다운로드용 파일명을 설정
				String downName = null;
				if(request.getHeader("user-agent").indexOf("MSIE") == -1)
				{
					downName = new String(fileName.getBytes("UTF-8"), "8859_1");
				}
				else
				{
					downName = new String(fileName.getBytes("EUC-KR"), "8859_1");
				}
				// ⑤ 무조건 다운로드하도록 설정
				response.setHeader("Content-Disposition","attachment;filename=\"" + downName + "\";");
				FileInputStream fis = new FileInputStream(realFile);
				ServletOutputStream sos = response.getOutputStream();
				try {
				 byte[] outByte = new byte[4096];
				 while(fis.read(outByte, 0, 4096) != -1)
				 {
				  sos.write(outByte, 0, 4096);
				 }
				} catch (Exception e) {
				 e.printStackTrace();
				} finally {
				 fis.close();
				 sos.flush();
				 sos.close();
				}
				path="/studyGroupKing/StudyGroupKingStorage.jsp";
				PageMove.redirect(request, response, path);
		}
		
	}
}
