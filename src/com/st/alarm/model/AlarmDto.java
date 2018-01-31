package com.st.alarm.model;

public class AlarmDto {
	
	private String a_content;
	private String a_type;
	private int ano;
	private int mno;
	private int a_sendmno;
	
	public String getA_content() {
		return a_content;
	}
	public String getA_type() {
		return a_type;
	}
	public int getAno() {
		return ano;
	}
	public int getMno() {
		return mno;
	}
	public int getA_sendmno() {
		return a_sendmno;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public void setA_type(String a_type) {
		this.a_type = a_type;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public void setA_sendmno(int a_sendmno) {
		this.a_sendmno = a_sendmno;
	}
}
