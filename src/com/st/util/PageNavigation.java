package com.st.util;

public class PageNavigation {
	
	//<<처음목록<이전목록	1 2 3 4 5 6 7 8 9 10 다음목록>끝목록>>
	
		private String root;
		private boolean nowFirst;	//현재 내페이지가 이전목록을 누를수 있는지 없는지 판단
		private boolean nowEnd;		//현재 내페이지가 다음목록을 누를수 있는지 없는지 판단
		private int totalArticleCount;//총글수
		private int newArticleCount;//총새글수
		private int totalPageCount;//총페이지
		private int pageNo;//페이지번호
		private String navigator;
		private String word;
		
		public String getRoot() {
			return root;
		}
		public void setRoot(String root) {
			this.root = root;
		}
		
		public String getWord() {
			return word;
		}
		public void setWord(String word) {
			this.word = word;
		}
		public void setNavigator(String navigator) {
			this.navigator = navigator;
		}
		public boolean isNowFirst() {
			return nowFirst;
		}
		public void setNowFirst(boolean nowFirst) {
			this.nowFirst = nowFirst;
		}
		public boolean isNowEnd() {
			return nowEnd;
		}
		public void setNowEnd(boolean nowEnd) {
			this.nowEnd = nowEnd;
		}
		public int getTotalArticleCount() {
			return totalArticleCount;
		}
		public void setTotalArticleCount(int totalArticleCount) {
			this.totalArticleCount = totalArticleCount;
		}
		public int getNewArticleCount() {
			return newArticleCount;
		}
		public void setNewArticleCount(int newArticleCount) {
			this.newArticleCount = newArticleCount;
		}
		public int getTotalPageCount() {
			return totalPageCount;
		}
		public void setTotalPageCount(int totalPageCount) {
			this.totalPageCount = totalPageCount;
		}
		public int getPageNo() {
			return pageNo;
		}
		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}
		public String getNavigator() {
			return navigator;
		}
		
		public void setNavigator() {

			StringBuffer tmpNavigator = new StringBuffer();
			
			int pageSize = BoardConstance.PAGE_SIZE;

			tmpNavigator.append("<ul class=\"pagination\" style=\"position: relative; left: 40%;\"> \n");
			if (this.isNowFirst()) {
				tmpNavigator.append("<li class=\"page-item disabled\"><a class=\"page-link\" href=\"#\">&laquo;</a></li> \n");
			} else {
				int prePage = (pageNo - 1) / pageSize * pageSize;
				tmpNavigator.append("  <li class=\"page-item\"><a class=\"page-link\" href=\"javascript:movePage('" + prePage + "','" + word + "');\">&laquo;</a></li> \n");
			}
			
			int startPage = (pageNo - 1) / pageSize * pageSize + 1;
			int endPage = startPage + pageSize - 1;
			if(endPage > totalPageCount) {
				endPage = totalPageCount;
			}
			for (int i = startPage; i <= endPage; i++) {
				if (pageNo == i) {
					tmpNavigator.append("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">" + i + "</a></li> \n");
				} else {
					tmpNavigator.append("<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:movePage('" + i + "','"+ word +"');\">"+ i + "</a></li> \n");
				}
			}
			if (this.isNowEnd()) {
				tmpNavigator.append("<li class=\"page-item disabled\"><a class=\"page-link\" href=\"#\">&raquo;</a></li> \n");
			} else {
				int nextPage = (pageNo - 1) / pageSize * pageSize + pageSize + 1;
				tmpNavigator.append("<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:movePage('" + nextPage + "','" + word + "');\">&raquo;</a></li>");
			}

			tmpNavigator.append("</ul>\n");

			this.navigator = tmpNavigator.toString();
		}
		
		

}
