package com.vocab.api.dao;

import com.vocab.api.base.IRepository;
import com.vocab.api.connection.RepositoryImpl;

public abstract class BaseDao {
	IRepository iRepository;
	
	public BaseDao() {
		super();
		initRepository();
	}

	public void initRepository() {
		iRepository = new RepositoryImpl();
	}
}
