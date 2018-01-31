package com.st.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.st.admin.service.AdminServiceImpl;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;
import com.st.util.PageMove;
import com.st.util.StringEncoder;

import sun.print.PrinterJobWrapper;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		System.out.println("admin act ===" + act);
		
		if("memberlist".equals(act)) {
			String key = request.getParameter("key");
			String word = StringEncoder.isoToEuc(request.getParameter("word"));
			List<MemberDto> list = AdminServiceImpl.getAdminService().listMember(key, word);
			request.setAttribute("mlist", list);
			PageMove.forward(request, response, "/xml/memberlist.jsp");
		}else if("mvmemberlist".equals(act)) {
			PageMove.forward(request, response, "/admin/admin_member.jsp");
		}else if("updatemember".equals(act)) {
			String status = request.getParameter("status");
		}else if("mvmemberchart".equals(act)) {
			PageMove.forward(request, response, "/admin/admin_memberchart.jsp");
		}else if("memberchart".equals(act)) {
			System.out.println("memberchart 왔냐?");
			List<Map> list  = AdminServiceImpl.getAdminService().memberChart();
			PrintWriter out = response.getWriter();
			JSONArray array = new JSONArray();
			JSONArray array1 = new JSONArray();	
			JSONArray array3 = new JSONArray();
			array1.put("year");
			array1.put("count");
			array.put(array1);
			int len = list.size();
			for(int i=0; i<len; i++) {
				JSONArray array2 = new JSONArray();
				array2.put(list.get(i).get("year"));
				array2.put(Integer.parseInt((String) list.get(i).get("count")));
				array.put(array2);
			}			
			out.print(array);			
		}else if("mvloginchart".equals(act)) {
			PageMove.forward(request, response, "/admin/admin_loginchart.jsp");
		}else if("loginchart".equals(act)) {
			System.out.println("loginchart 왔냐?");
			List<Map> list  = AdminServiceImpl.getAdminService().loginChart();
			PrintWriter out = response.getWriter();
			JSONArray array3 = new JSONArray();
			JSONArray array1 = new JSONArray();	
			array1.put("id");
			array1.put("count");
			array3.put(array1);
			int len = list.size();
			for(int i=0; i<len; i++) {
				JSONArray array2 = new JSONArray();
				array2.put(list.get(i).get("id"));
				array2.put(Integer.parseInt((String) list.get(i).get("count")));
				array3.put(array2);
			}			
			out.print(array3);			
		} else if("spacelist".equals(act)) {
			String key = request.getParameter("key");
			String word = StringEncoder.isoToEuc(request.getParameter("word"));
			List<StudySpaceDto> list = AdminServiceImpl.getAdminService().listSpace(key, word);
			request.setAttribute("slist", list);
			PageMove.forward(request, response, "/xml/spacelist.jsp");
		}else if("mvspacelist".equals(act)) {
			PageMove.forward(request, response, "/admin/admin_studyspace.jsp");
		}else if("dashlist".equals(act)) {
			List<StudySpaceDto> dslist = AdminServiceImpl.getAdminService().dashSpace();
			List<MemberDto> dmlist = AdminServiceImpl.getAdminService().dashMember();
			List<StudyGroupDto> dglist = AdminServiceImpl.getAdminService().dashGroup();
			request.setAttribute("dmlist", dmlist);
			request.setAttribute("dslist", dslist);
			request.setAttribute("dglist", dglist);
			PageMove.forward(request, response, "/xml/dashlist.jsp");
		}else if("addresslist".equals(act)) {
				List<StudyRoomDto> alist = AdminServiceImpl.getAdminService().addressList();
				request.setAttribute("alist", alist);
				PageMove.forward(request, response, "/xml/addresslist.jsp");
		}else if("stglist".equals(act)) {
			String key = request.getParameter("key");
			String word = StringEncoder.isoToEuc(request.getParameter("word"));
			List<StudyGroupDto> list = AdminServiceImpl.getAdminService().listStudygroup(key, word);
			request.setAttribute("glist", list);
			PageMove.forward(request, response, "/xml/stglist.jsp");
		}else if("mvstglist".equals(act)) {
			PageMove.forward(request, response, "/admin/admin_studygroup.jsp");
		}else if("changestat".equals(act)) {
			String no = request.getParameter("no");
			System.out.println(no);
			int num = Integer.parseInt(request.getParameter("num"));
			String stat = request.getParameter("stat");
			AdminServiceImpl.getAdminService().updateStat(num,stat,no);
		}else if("changetag".equals(act)) {
			String no = request.getParameter("no");
			System.out.println(no);
			int num = Integer.parseInt(request.getParameter("num"));
			String enc = URLEncoder.encode(request.getParameter("tag"), "ISO-8859-1");
			String tag = URLDecoder.decode(enc, "UTF-8");
			System.out.println(tag);
			AdminServiceImpl.getAdminService().updateTag(num,tag,no);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
