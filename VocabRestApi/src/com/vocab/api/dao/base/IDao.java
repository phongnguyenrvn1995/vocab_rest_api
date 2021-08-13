package com.vocab.api.dao.base;

import java.util.List;

public interface IDao <T>{
	int getAllCount(String searchStr);
	List<T> getAll(String searchStr);
	List<T> getAll(String searchStr, int limit, int offset);
	T get(int id);
	boolean save(T t);
	boolean update(T t);
	boolean delete(T t);	
}
