package com.test.web.dao;

import java.util.List;

import com.test.web.bean.BoardBean;

public interface BoardDao {
	
	public BoardBean selectBoard(BoardBean bean);
	
	public List<BoardBean> selectBoardList();
	
	/** 회원 가입*/
	public int insertBoard(BoardBean bean);
	
	/** 회원 수정*/
	public int updateBoard(BoardBean bean);
	
	/** 회원 삭제*/
	public int deleteBoard(BoardBean bean);

}
