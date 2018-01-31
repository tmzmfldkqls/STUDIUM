package com.st.factory;

import com.st.member.action.MemberFindidAction;
import com.st.member.action.MemberFindpwdAction;
import com.st.member.action.MemberLoginAction;
import com.st.member.action.MemberRegisterAction;

public class MemberActionFactory {
	
	private static MemberRegisterAction memberRegisterAction;
	private static MemberLoginAction memberLoginAction;
	private static MemberFindidAction memberFindidAction;
	private static MemberFindpwdAction memberFindpwdAction;
	static {
		memberRegisterAction = new MemberRegisterAction();
		memberLoginAction = new MemberLoginAction();
		memberFindidAction = new MemberFindidAction();
		memberFindpwdAction = new MemberFindpwdAction();
	}
	
	public static MemberFindpwdAction getMemberFindpwdAction() {
		return memberFindpwdAction;
	}

	public static MemberFindidAction getMemberFindidAction() {
		return memberFindidAction;
	}

	public static MemberLoginAction getMemberLoginAction() {
		return memberLoginAction;
	}

	public static MemberRegisterAction getMemberRegisterAction() {
		return memberRegisterAction;
	}
		

}
