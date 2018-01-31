package com.st.studyroom.model;

public class SpAddDto {

	private String AP_ZIPCODE; /* 집코드 */
	private String SP_SI;/* 시 */
	private String SP_GUGUN ;/* 구 */
	private String SP_DONG ; /* 동 */
	private String AP_BUNJI ; /* 번지 */
	private String SP_DETAIL_addr;/* 상세주소 */
	private String SP_GEO;
	
	public String getSP_GEO() {
		return SP_GEO;
	}
	public void setSP_GEO(String sP_GEO) {
		SP_GEO = sP_GEO;
	}
	public String getAP_ZIPCODE() {
		return AP_ZIPCODE;
	}
	public void setAP_ZIPCODE(String aP_ZIPCODE) {
		AP_ZIPCODE = aP_ZIPCODE;
	}
	public String getSP_SI() {
		return SP_SI;
	}
	public void setSP_SI(String sP_SI) {
		SP_SI = sP_SI;
	}
	public String getSP_GUGUN() {
		return SP_GUGUN;
	}
	public void setSP_GUGUN(String sP_GUGUN) {
		SP_GUGUN = sP_GUGUN;
	}
	public String getSP_DONG() {
		return SP_DONG;
	}
	public void setSP_DONG(String sP_DONG) {
		SP_DONG = sP_DONG;
	}
	public String getAP_BUNJI() {
		return AP_BUNJI;
	}
	public void setAP_BUNJI(String aP_BUNJI) {
		AP_BUNJI = aP_BUNJI;
	}
	public String getSP_DETAIL_addr() {
		return SP_DETAIL_addr;
	}
	public void setSP_DETAIL_addr(String sP_DETAIL_addr) {
		SP_DETAIL_addr = sP_DETAIL_addr;
	}
	
}
