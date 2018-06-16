package com.dgit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.ManagerVO;
import com.dgit.persistence.ManDAO;

@Service
public class ManServiceImpl implements ManService {
	
	@Autowired
	ManDAO dao;

	@Override
	public ManagerVO login(ManagerVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}	
	
	
	
}
