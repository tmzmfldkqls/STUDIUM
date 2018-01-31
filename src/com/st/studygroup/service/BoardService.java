package com.st.studygroup.service;

import java.util.List;

import com.st.studygroup.model.BoardDto;

public interface BoardService {
	
	int writeArticle(BoardDto boardDto);
	BoardDto viewArticle(int WNO);
	void deleteArticle(int WNO);
	void modifyArticle(BoardDto boardDto);
	List<BoardDto> noticelist(int SNO);
}
