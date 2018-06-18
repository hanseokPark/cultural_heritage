package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.BoardVO;
import com.dgit.domain.ManagerVO;
import com.dgit.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession session;
	
	private static final String namespace = "com.dgit.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read",bno);
	}
	
	@Override
	public BoardVO selectPass(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".selectPass", bno);
	}
	
	@Override
	public ManagerVO selectManagerPass() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".selectManagerPass");
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".update", vo);
	}

	@Override
	public void delete(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub		
		session.delete(namespace + ".delete", vo);
	}

	@Override
	public void deleteManager(int bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteManager", bno);
	}
	
	@Override
	public int updateViewCnt(int bno) throws Exception {
		return session.update(namespace + ".updateViewCnt", bno);
		
	}
	
	@Override
	public int totalSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".totalSearchCount" ,cri) ;
	}
	
	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listSearch", cri);
	}
	
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		page = (page-1)*10;
		return session.selectList(namespace + ".listPage", page);
	}
	
	@Override
	public int totalCount() throws Exception {
		// TODO Auto-generated method stub	
		return session.selectOne(namespace + ".totalCount");
	}

	

	

	





	
}
