package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgit.domain.BoardVO;
import com.dgit.domain.Criteria;
import com.dgit.domain.ManagerVO;
import com.dgit.domain.SearchCriteria;
import com.dgit.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;	
	
	@Transactional
	@Override
	public void regist(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub		
		dao.create(vo);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub						
		BoardVO vo = dao.read(bno);
		return vo;
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);		
	}

	@Override
	public void remove(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub		
		dao.delete(vo);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception{
		return dao.listCriteria(cri);
	}
	@Override
	public int totalCount() throws Exception{
		return dao.totalCount();
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int totalSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.totalSearchCount(cri);
	}

	@Override
	public int boardviewcnt(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateViewCnt(bno);
	}

	@Override
	public void deleteAttach(int bno, String fullName) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteAttach(bno,fullName);		
		
	}

	@Override
	public BoardVO selectPass(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPass(bno);
	}

	@Override
	public ManagerVO selectManagerPass() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectManagerPass();
	}

	@Override
	public void removeManager(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteManager(bno);	
	}

/*	@Override
	public ManagerVO login(ManagerVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}*/

	/*@Override
	public void modaddAttach(String fullName, int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.modaddAttach(fullName, bno);
	}*/

	
}
