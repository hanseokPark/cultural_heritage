package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.BoardVO;
import com.dgit.domain.ManagerVO;
import com.dgit.domain.SearchCriteria;

public interface BoardDAO {
	public void create(BoardVO vo) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public BoardVO read(int bno) throws Exception;
	public BoardVO selectPass(int bno) throws Exception;
	public ManagerVO selectManagerPass() throws Exception;
	
	
	//게시판 삭제
	public void update(BoardVO vo) throws Exception;
	public void delete(BoardVO vo) throws Exception;
	public void deleteManager(int bno) throws Exception;
	public int updateViewCnt(int bno) throws Exception;  //게시판 조회수
	
	
	//페이징
	public int totalSearchCount(SearchCriteria cri) throws Exception;
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	
	
	public List<BoardVO> listPage(int page) throws Exception;
	public int totalCount() throws Exception;
	
	
	
}
