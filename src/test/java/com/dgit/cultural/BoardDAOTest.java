package com.dgit.cultural;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.BoardVO;
import com.dgit.domain.SearchCriteria;
import com.dgit.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/Web-inf/spring/**/*.xml"})
public class BoardDAOTest {
	
	@Autowired
	BoardDAO dao;
	
	//@Test
	public void testCreate() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setTitle("title test");
		vo.setContent("content test");
		vo.setWriter("테스트");
		vo.setUr_pass(1234);
		
		dao.create(vo);
	}
	//@Test
	public void read() throws Exception{
		
		BoardVO boardvo = dao.read(1);
		
		System.out.println(boardvo);
	}
	
	//@Test
	public void update() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setTitle("title test1");
		vo.setContent("content test1");
		vo.setBno(3);
		
		dao.update(vo);
		
	}
	
	//@Test
	public void delete() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setBno(4);
		vo.setUr_pass(1234);
		
		dao.delete(vo);
	}
	
	//@Test
	public void readAll() throws Exception{
		List<BoardVO> vo = dao.listAll();
		System.out.println(vo);
	}
	
	//@Test
	public void testListPage() throws Exception{		
		System.out.println(dao.listPage(1));
	}
	
	//@Test
	public int testtotalCount() throws Exception{
		return dao.totalCount();
	}
	
	//@Test
	public void testlistSearch() throws Exception{
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setSearchType("t");
		cri.setKeyword("title");
		
		System.out.println(dao.listSearch(cri));
	}
	
}








