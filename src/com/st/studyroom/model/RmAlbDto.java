package com.st.studyroom.model;

public class RmAlbDto {
	private int INO; /* 이미지번호 */
	private int SPNO; /* 방번호 */
	private String I_STATUS; /* 이미지상태 */
	private String SAVEFOLDER; /* 세이브폴더 */
	private String ORIGIN_IMG; /* 오리지널 */
	private String SAVE_IMG; /* 실저장 */
	
	public int getINO() {
		return INO;
	}
	public void setINO(int iNO) {
		INO = iNO;
	}

	public int getSPNO() {
		return SPNO;
	}
	public void setSPNO(int sPNO) {
		SPNO = sPNO;
	}
	public String getI_STATUS() {
		return I_STATUS;
	}
	public void setI_STATUS(String i_STATUS) {
		I_STATUS = i_STATUS;
	}
	public String getSAVEFOLDER() {
		return SAVEFOLDER;
	}
	public void setSAVEFOLDER(String sAVEFOLDER) {
		SAVEFOLDER = sAVEFOLDER;
	}
	public String getORIGIN_IMG() {
		return ORIGIN_IMG;
	}
	public void setORIGIN_IMG(String oRIGIN_IMG) {
		ORIGIN_IMG = oRIGIN_IMG;
	}
	public String getSAVE_IMG() {
		return SAVE_IMG;
	}
	public void setSAVE_IMG(String sAVE_IMG) {
		SAVE_IMG = sAVE_IMG;
	}
	

}
