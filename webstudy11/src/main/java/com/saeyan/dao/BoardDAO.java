package com.saeyan.dao;

import java.util.List;

import com.saeyan.dto.BoardVO;

public class BoardDAO {
	private BoardDAO() {
	}
	
	private static BoardDAO instance =  new BoardDAO();
	
	private static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> selectAllBoards() {
		return null;
	}

}
