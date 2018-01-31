package com.st.studygroup.model;

import java.io.Serializable;

import com.st.member.model.MemberDto;

public class StudyGroupDto implements Serializable{
	/*	
	SNO	NUMBER
	MNO	NUMBER
	S_ID 	VARCHAR2(12 CHAR)
	S_NAME	VARCHAR2(30 CHAR)
	S_CONTENT	VARCHAR2(2000 CHAR)
	S_TAG	VARCHAR2(80 CHAR
	S_MEMBER	 VARCHAR2(40 CHAR)
	S_PERSON 	NUMBER
	S_MAXPERSON	NUMBER
	S_CURR_STATUS	VARCHAR2(1 CHAR)
	S_BEING	VARCHAR2(1 CHAR)
	 */
	private int SNO;
	private int MNO;
	private String S_ID;
	private String S_NAME;
	private String S_CONTENT;
	private String S_TAG;
	private String S_MEMBER;
	private int S_PERSON;
	private int S_MAXPERSON;
	private String S_CURR_STATUS;
	private String S_BEING;
	private String S_DATE;

	public String getS_DATE() {
		return S_DATE;
	}
	public void setS_DATE(String s_DATE) {
		S_DATE = s_DATE;
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
	public String getS_ID() {
		return S_ID;
	}
	public void setS_ID(String s_ID) {
		S_ID = s_ID;
	}
	public String getS_NAME() {
		return S_NAME;
	}
	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}
	public String getS_CONTENT() {
		return S_CONTENT;
	}
	public void setS_CONTENT(String s_CONTENT) {
		S_CONTENT = s_CONTENT;
	}
	public String getS_TAG() {
		return S_TAG;
	}
	public void setS_TAG(String s_TAG) {
		S_TAG = s_TAG;
	}
	public String getS_MEMBER() {
		return S_MEMBER;
	}
	public void setS_MEMBER(String s_MEMBER) {
		S_MEMBER = s_MEMBER;
	}
	public int getS_PERSON() {
		return S_PERSON;
	}
	public void setS_PERSON(int s_PERSON) {
		S_PERSON = s_PERSON;
	}
	public int getS_MAXPERSON() {
		return S_MAXPERSON;
	}
	public void setS_MAXPERSON(int s_MAXPERSON) {
		S_MAXPERSON = s_MAXPERSON;
	}
	public String getS_CURR_STATUS() {
		return S_CURR_STATUS;
	}
	public void setS_CURR_STATUS(String s_CURR_STATUS) {
		S_CURR_STATUS = s_CURR_STATUS;
	}
	public String getS_BEING() {
		return S_BEING;
	}
	public void setS_BEING(String s_BEING) {
		S_BEING = s_BEING;
	}
	
}