package com.dgit.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.ManagerVO;

@Repository
public class ManDAOImpl implements ManDAO {

	@Autowired
	SqlSession session;
	
	private static final String namespace = "com.dgit.mapper.ManMapper";

	@Override
	public ManagerVO login(ManagerVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".login", vo);
	}

	
	
	
	
}
