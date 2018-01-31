package com.st.admin.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.st.admin.dao.AdminDaoImpl;
import com.st.member.model.MemberDto;
import com.st.studygroup.model.StudyGroupDto;
import com.st.studyroom.model.StudyRoomDto;
import com.st.studyroom.model.StudySpaceDto;

public class AdminServiceImpl implements AdminService {

	private static AdminService adminService;
	
	static {
		adminService = new AdminServiceImpl();
	}
	
	public static AdminService getAdminService() {
		return adminService;
	}
	private AdminServiceImpl( ) {}
	@Override
	public List<MemberDto> listMember(String key, String word) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		map.put("date", "");
		return AdminDaoImpl.getAdminDao().listMember(map);
	}
	@Override
	public int updatemember(String status) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<MemberDto> dashMember() {
		Map<String,String> map = new HashMap<String, String>();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String today = df.format(new Date());
        map.put("key", "");
		map.put("word", "");
		map.put("date", today);
		return AdminDaoImpl.getAdminDao().listMember(map);
	}
	@Override
	public List<Map> memberChart() {
		return AdminDaoImpl.getAdminDao().memberChart();
	}
	@Override
	public List<Map> loginChart() {
		// TODO Auto-generated method stub
		return AdminDaoImpl.getAdminDao().loginChart();
	}
	@Override
	public List<StudyRoomDto> addressList() {
		// TODO Auto-generated method stub
		return AdminDaoImpl.getAdminDao().addressList();
	}
	@Override
	public List<StudySpaceDto> listSpace(String key, String word) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		map.put("date", "");
		return AdminDaoImpl.getAdminDao().listSpace(map);
	}
	@Override
	public List<StudySpaceDto> dashSpace() {
		Map<String,String> map = new HashMap<String, String>();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String today = df.format(new Date());
        map.put("key", "");
		map.put("word", "");
		map.put("date", today);
		return AdminDaoImpl.getAdminDao().listSpace(map);
	}
	@Override
	public List<StudyGroupDto> listStudygroup(String key, String word) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		map.put("date", "");
		return AdminDaoImpl.getAdminDao().listStudygroup(map);
	}
	@Override
	public void updateStat(int num, String stat, String no) {
		if("mno".equals(no)) {
		AdminDaoImpl.getAdminDao().updateMemStat(num,stat);
		}else if("spno".equals(no)) {
			AdminDaoImpl.getAdminDao().updateSpStat(num,stat);
		}else if("snobstatus".equals(no)) {
			AdminDaoImpl.getAdminDao().updateBStgStat(num,stat);
		}else if("snostatus".equals(no)) {
			AdminDaoImpl.getAdminDao().updateStgStat(num,stat);
		}
	}
	@Override
	public void updateTag(int num, String tag, String no) {
		System.out.println("service");
		if("mno".equals(no)) {
			AdminDaoImpl.getAdminDao().updateMemTag(num,tag);
		}else if("spno".equals(no)) {
			AdminDaoImpl.getAdminDao().updateSpTag(num,tag);
		}else if("sno".equals(no)) {
			AdminDaoImpl.getAdminDao().updateStgTag(num,tag);
		}		
	}
	@Override
	public List<StudyGroupDto> dashGroup() {
		Map<String,String> map = new HashMap<String, String>();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String today = df.format(new Date());
        map.put("key", "");
		map.put("word", "");
		map.put("date", today);
		return AdminDaoImpl.getAdminDao().listStudygroup(map);
	}
}
