package com.st.studygroup.service;

import java.util.List;

import com.st.studygroup.dao.BoardDao;
import com.st.studygroup.dao.BoardDaoImpl;
import com.st.studygroup.model.BoardDto;

public class BoardServiceImpl implements BoardService {
	
private static BoardService boardService;
	
	static {
		boardService = new BoardServiceImpl();
	}
	
	private BoardServiceImpl() {}
	
	
	public static BoardService getBoardService() {
		return boardService;
	}


	@Override
	public int writeArticle(BoardDto boardDto) {
		int cnt = BoardDaoImpl.getBoardDao().writeArticle(boardDto);
		return cnt;
	}



	@Override
	public BoardDto viewArticle(int WNO) {		
		return BoardDaoImpl.getBoardDao().viewArticle(WNO);
	}


	@Override
	public void deleteArticle(int WNO) {
		BoardDaoImpl.getBoardDao().deleteArticle(WNO);		
	}


	@Override
	public void modifyArticle(BoardDto boardDto) {
		BoardDaoImpl.getBoardDao().modifyArticle(boardDto);
		
	}


	@Override
	public List<BoardDto> noticelist(int SNO) {
		return BoardDaoImpl.getBoardDao().noticelist(SNO);
	}

	
}
