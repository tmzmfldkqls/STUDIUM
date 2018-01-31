package com.st.studygroup.model;

import com.st.member.model.MemberDto;

public class StudyGroupMemberDto extends MemberDto{
	
	private int SMNO;
	private int SNO;
	private int MNO;
	
	
	public int getSMNO() {
		return SMNO;
	}
	public void setSMNO(int sMNO) {
		SMNO = sMNO;
	}
	public int getSNO() {
		return SNO;
	}
	public void setSNO(int sNO) {
		SNO = sNO;
	}
	public int getMNO() {
		return MNO;
	}
	public void setMNO(int mNO) {
		MNO = mNO;
	}
	
	
	

}
