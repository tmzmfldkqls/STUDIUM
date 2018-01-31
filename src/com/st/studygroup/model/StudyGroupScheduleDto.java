package com.st.studygroup.model;

public class StudyGroupScheduleDto {
	
	private int STNO;
	private int SNO;
	private String ST_DATE_IN;
	private String ST_DATE_OUT;
	private String ST_TIME_IN;
	private String ST_TIME_OUT;
	private String ST_CONTENT;
	private String ST_NAME;
	
	
	public String getST_NAME() {
		return ST_NAME;
	}
	public void setST_NAME(String sT_NAME) {
		ST_NAME = sT_NAME;
	}
	public int getSTNO() {
		return STNO;
	}
	public void setSTNO(int sTNO) {
		STNO = sTNO;
	}
	public int getSNO() {
		return SNO;
	}
	public void setSNO(int sNO) {
		SNO = sNO;
	}
	public String getST_DATE_IN() {
		return ST_DATE_IN;
	}
	public void setST_DATE_IN(String sT_DATE_IN) {
		ST_DATE_IN = sT_DATE_IN;
	}
	public String getST_DATE_OUT() {
		return ST_DATE_OUT;
	}
	public void setST_DATE_OUT(String sT_DATE_OUT) {
		ST_DATE_OUT = sT_DATE_OUT;
	}
	public String getST_TIME_IN() {
		return ST_TIME_IN;
	}
	public void setST_TIME_IN(String sT_TIME_IN) {
		ST_TIME_IN = sT_TIME_IN;
	}
	public String getST_TIME_OUT() {
		return ST_TIME_OUT;
	}
	public void setST_TIME_OUT(String sT_TIME_OUT) {
		ST_TIME_OUT = sT_TIME_OUT;
	}
	public String getST_CONTENT() {
		return ST_CONTENT;
	}
	public void setST_CONTENT(String sT_CONTENT) {
		ST_CONTENT = sT_CONTENT;
	}

}
