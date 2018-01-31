package com.st.studyroom.model;

public class ReservationDto {

	private int RMRNO; /* 방예약번호 */
	private int RM_NO; /* 방번호 */
	private int MNO; /* 회원번호 */
	
	private String RMR_ID; /* 방예약회원아이디 */
	private int RMR_PRICE; /* 가격 */
	private int RMR_PERSON; /* 인원 */
	private String RMR_DATE_IN; /* 방사용날짜(IN) */
	private String RMR_DATE_OUT;/* 방사용날짜(OUT) */
	private String RMR_TIME_IN; /* 방사용시간(IN) */
	private String RMR_TIME_OUT; /* 방사용시간(OUT) */
	private String RMR_TEL; /* 방예약자연락처 */
	private String RMR_EMAIL;/* 방예약자이메일 */
	private String RMR_DATE; /* 방예약한날짜 */
	private String RMR_CONTENT; /* 요청사항 */
	
	private String SP_NAME;/*테이블에는 없는 필드. 공간이름*/
	private String RM_NAME;/*테이블에는 없는 필드. 방이름이름*/
	
	public int getRMRNO() {
		return RMRNO;
	}
	public void setRMRNO(int rMRNO) {
		RMRNO = rMRNO;
	}
	public int getRM_NO() {
		return RM_NO;
	}
	public void setRM_NO(int rM_NO) {
		RM_NO = rM_NO;
	}
	public int getMNO() {
		return MNO;
	}
	public void setMNO(int mNO) {
		MNO = mNO;
	}
	public String getRMR_ID() {
		return RMR_ID;
	}
	public void setRMR_ID(String rMR_ID) {
		RMR_ID = rMR_ID;
	}
	public int getRMR_PRICE() {
		return RMR_PRICE;
	}
	public void setRMR_PRICE(int rMR_PRICE) {
		RMR_PRICE = rMR_PRICE;
	}
	public int getRMR_PERSON() {
		return RMR_PERSON;
	}
	public void setRMR_PERSON(int rMR_PERSON) {
		RMR_PERSON = rMR_PERSON;
	}
	public String getRMR_DATE_IN() {
		return RMR_DATE_IN;
	}
	public void setRMR_DATE_IN(String rMR_DATE_IN) {
		RMR_DATE_IN = rMR_DATE_IN;
	}
	public String getRMR_DATE_OUT() {
		return RMR_DATE_OUT;
	}
	public void setRMR_DATE_OUT(String rMR_DATE_OUT) {
		RMR_DATE_OUT = rMR_DATE_OUT;
	}
	public String getRMR_TIME_IN() {
		return RMR_TIME_IN;
	}
	public void setRMR_TIME_IN(String rMR_TIME_IN) {
		RMR_TIME_IN = rMR_TIME_IN;
	}
	public String getRMR_TIME_OUT() {
		return RMR_TIME_OUT;
	}
	public void setRMR_TIME_OUT(String rMR_TIME_OUT) {
		RMR_TIME_OUT = rMR_TIME_OUT;
	}
	public String getRMR_TEL() {
		return RMR_TEL;
	}
	public void setRMR_TEL(String rMR_TEL) {
		RMR_TEL = rMR_TEL;
	}
	public String getRMR_EMAIL() {
		return RMR_EMAIL;
	}
	public void setRMR_EMAIL(String rMR_EMAIL) {
		RMR_EMAIL = rMR_EMAIL;
	}
	public String getRMR_DATE() {
		return RMR_DATE;
	}
	public void setRMR_DATE(String rMR_DATE) {
		RMR_DATE = rMR_DATE;
	}
	public String getRMR_CONTENT() {
		return RMR_CONTENT;
	}
	public void setRMR_CONTENT(String rMR_CONTENT) {
		RMR_CONTENT = rMR_CONTENT;
	}
	public String getSP_NAME() {
		return SP_NAME;
	}
	public void setSP_NAME(String sP_NAME) {
		SP_NAME = sP_NAME;
	}
	public String getRM_NAME() {
		return RM_NAME;
	}
	public void setRM_NAME(String rM_NAME) {
		RM_NAME = rM_NAME;
	}
	
	
	
	
}
