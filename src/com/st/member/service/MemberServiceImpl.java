package com.st.member.service;

import java.util.HashMap;
import java.util.Map;

import com.st.member.dao.MemberDaoImpl;
import com.st.member.model.MemberDto;

public class MemberServiceImpl implements MemberService {

	
	private static MemberService memberService;
	
	static {
		memberService = new MemberServiceImpl();
	}
	
	private MemberServiceImpl() {}
	
	public static MemberService getMemberService() {
		return memberService;
	}

	@Override
	public int registerMember(MemberDto memberDto) {
		int cnt = MemberDaoImpl.getMemberDao().registerMember(memberDto);
		return cnt;
	}

	@Override
	public MemberDto login(String id, String pass) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		return MemberDaoImpl.getMemberDao().login(map);
	}

	@Override
	public MemberDto findid(String name, String tel) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", name);
		map.put("usertel", tel);
		return MemberDaoImpl.getMemberDao().findid(map);
	}

	@Override
	public MemberDto findpwd(String id, String email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("useremail", email);
		
		return MemberDaoImpl.getMemberDao().findpwd(map);
	}

	@Override
	public void updatepwd(int mno, String tmppwd) {
		MemberDaoImpl.getMemberDao().updatepwd(mno, tmppwd);		
	}

	@Override
	public int idCheck(String id) {
		return MemberDaoImpl.getMemberDao().idCheck(id);
	}

}
