package com.st.studyroom.model;

public class StudySpaceDto extends SpAddDto {


	
	private int SPNO; /* 공간번호 */
	private int MNO; /* 회원번호 */
	private String SP_ID; /* 공간등록자아이디 */
	private String SP_NAME ; /* 공간명 */
	private String SP_SCONTENT; /* 공간한줄소개 */
	private String SP_CONTENT; /* 공간소개 */
	private String SP_TAG; /* 공간태그 */
	private String SP_IMG;/* 공간대표이미지 */
	private int	SP_FLAG;/* 예약 받을지 말지 여부*/
	private String SP_WEB;
	private int FOOTPRINT;
	private String SP_ST;
	
	public String getSP_ST() {
		return SP_ST;
	}
	public void setSP_ST(String sP_ST) {
		SP_ST = sP_ST;
	}
	public int getSPNO() {
		return SPNO;
	}
	public void setSPNO(int sPNO) {
		SPNO = sPNO;
	}
	public int getMNO() {
		return MNO;
	}
	public void setMNO(int mNO) {
		MNO = mNO;
	}
	public String getSP_ID() {
		return SP_ID;
	}
	public void setSP_ID(String sP_ID) {
		SP_ID = sP_ID;
	}
	public String getSP_NAME() {
		return SP_NAME;
	}
	public void setSP_NAME(String sP_NAME) {
		SP_NAME = sP_NAME;
	}
	public String getSP_SCONTENT() {
		return SP_SCONTENT;
	}
	public void setSP_SCONTENT(String sP_SCONTENT) {
		SP_SCONTENT = sP_SCONTENT;
	}
	public String getSP_CONTENT() {
		return SP_CONTENT;
	}
	public void setSP_CONTENT(String sP_CONTENT) {
		SP_CONTENT = sP_CONTENT;
	}
	public String getSP_TAG() {
		return SP_TAG;
	}
	public void setSP_TAG(String sP_TAG) {
		SP_TAG = sP_TAG;
	}
	public String getSP_IMG() {
		return SP_IMG;
	}
	public void setSP_IMG(String sP_IMG) {
		SP_IMG = sP_IMG;
	}
	public int getSP_FLAG() {
		return SP_FLAG;
	}
	public void setSP_FLAG(int sP_FLAG) {
		SP_FLAG = sP_FLAG;
	}
	public String getSP_WEB() {
		return SP_WEB;
	}
	public void setSP_WEB(String sP_WEB) {
		SP_WEB = sP_WEB;
	}
	public int getFOOTPRINT() {
		return  FOOTPRINT;
	}
	public void setFOOTPRINT(int  FOOTPRINT) {
		this. FOOTPRINT =  FOOTPRINT;
	}
	
	
}
