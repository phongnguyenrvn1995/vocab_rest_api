package com.vocab.api.dao;

import com.vocab.api.base.IRepository;
import com.vocab.api.connection.RepositoryImpl;

public abstract class AbsDao {
	IRepository iRepository;
	
	public AbsDao() {
		super();
		initRepository();
	}

	public void initRepository() {
		iRepository = new RepositoryImpl();
	}
}
