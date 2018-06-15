package com.dgit.persistence;

import com.dgit.domain.ManagerVO;

public interface ManDAO {
	public ManagerVO login(ManagerVO vo) throws Exception;

}
