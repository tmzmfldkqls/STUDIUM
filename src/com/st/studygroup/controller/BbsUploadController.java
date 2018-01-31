package com.st.studygroup.controller;

import java.io.File;
import java.io.IOException;
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
import com.st.member.model.MemberDto;
import com.st.studygroup.model.BbsGroupDto;
import com.st.studygroup.model.BoardListDto;
import com.st.studygroup.service.BbsServiceImpl;
import com.st.util.BoardConstance;
import com.st.util.PageMove;

@WebServlet("/fileUpload")
public class BbsUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String realPath;
	private int maxSize;
	private String encoding;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		realPath = config.getServletContext().getRealPath("/upload");
		maxSize = 10 * 1024 * 1024; // 1GB
		encoding = BoardConstance.MAIN_ENCODING;
		System.out.println(">>>>>>>>"+ realPath);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/main/login.jsp";
		HttpSession session = request.getSession();
		List<BoardListDto> bdlist = (List<BoardListDto>) session.getAttribute("groupInfo");
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
				String saveDirectory = realPath + File.separator; // 파일구분자를 알아서 나눠준다
				File file = new File(saveDirectory);
				if (!file.exists()) {
					file.mkdirs();
				}
				MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxSize, encoding,
						new DefaultFileRenamePolicy());
				 File uploadFile = multi.getFile("uploadfile");
				 String originalFileName = multi.getOriginalFileName("uploadfile");
				BbsGroupDto bbsGroupDto = new BbsGroupDto();
				bbsGroupDto.setSNO(bdlist.get(1).getSNO());
				bbsGroupDto.setBNO(bdlist.get(1).getBNO());
				bbsGroupDto.setBTNO(bdlist.get(1).getBTNO());
				bbsGroupDto.setF_ID(memberDto.getM_ID());
				bbsGroupDto.setF_CONTENT(multi.getParameter("fileContent").replace("<", "&lt;").replace(">", "&gt"));
				bbsGroupDto.setF_NAME(originalFileName);
				bbsGroupDto.setF_PATH(saveDirectory);
				System.out.println("saveDirectory>>>>>>>>>>>>>>" + saveDirectory);
				int cnt = BbsServiceImpl.getBbsService().upLoad(bbsGroupDto);
				if (cnt != 0) {
					path = "/bbs?act=mvmygroupbbs";
					PageMove.forward(request, response, path);
				} else {
					PageMove.forward(request, response, path);
				}

			}
		}
	}

