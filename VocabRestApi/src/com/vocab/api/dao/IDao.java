package com.vocab.api.dao;

import java.util.List;

public interface IDao <T>{
	List<T> getAll();
	T get(int id);
	boolean save(T t);
	boolean update(T t);
	boolean delete(T t);	
}
