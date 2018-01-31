package com.st.util;


	
	public class NullCheck {

		public static int nullToZero(String tmp) {
			int num = 999;
			if(isNumber(tmp)) {
				num = Integer.parseInt(tmp);
			}
			return num;
		}
		

		public static int nullToOne(String tmp) {
			int num = 1;
			if(isNumber(tmp)) {
				num = Integer.parseInt(tmp);
			}
			return num;
		}

		private static boolean isNumber(String tmp) {
			boolean flag = true;
			if(tmp != null) {
				int len = tmp.length();
				for(int i=0;i<len;i++) {
					int x = tmp.charAt(i) - 48;
					if(x < 0 || x > 9) {
						flag = false;
						break;
					}
				}
			} else {
				flag = false;
			}
			return flag;
		}


	}
