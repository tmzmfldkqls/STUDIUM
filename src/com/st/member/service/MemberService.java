package com.st.member.service;

import com.st.member.model.MemberDto;

public interface MemberService {
	
	int registerMember(MemberDto memberDto);
	MemberDto login(String id, String pass);
	MemberDto findid(String name, String tel);
	MemberDto findpwd(String id, String email);
	void updatepwd(int mno,String tmppwd);
	int idCheck(String id);

}
