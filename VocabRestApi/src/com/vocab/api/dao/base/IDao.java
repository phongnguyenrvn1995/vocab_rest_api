package com.vocab.api.dao.base;

import java.util.List;

public interface IDao <T>{
	List<T> getAll();
	List<T> getAll(int limit, int offset);
	T get(int id);
	boolean save(T t);
	boolean update(T t);
	boolean delete(T t);	
}
