package com.st.member.dao;

import java.util.Map;

import com.st.member.model.MemberDto;

public interface MemberDao {
	int registerMember(MemberDto memberDto);
	MemberDto login(Map<String,String> map);
	MemberDto findid(Map<String,String> map);
	MemberDto findpwd(Map<String,String> map);
	void updatepwd(int mno,String tmppwd);
	int idCheck(String id);
}
