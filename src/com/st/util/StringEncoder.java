package com.st.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringEncoder {
	
	public static String isoToEuc(String tmp) {
		String euc = "";
		try {
			if(tmp != null)
				euc = new String(tmp.getBytes("ISO-8859-1"), "EUC-KR");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return euc;
	}
	
	public static String urlFormat(String tmp) {
		String url = "";
		try {
			if(tmp != null)
				url = URLEncoder.encode(tmp, BoardConstance.MAIN_ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}
}
