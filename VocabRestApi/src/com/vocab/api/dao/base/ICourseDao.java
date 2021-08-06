package com.vocab.api.dao.base;

import java.util.List;

public interface ICourseDao<T> extends IDao<T>{
	List<T> getAllByStatusID(int id);
	List<T> getAllByStatusID(int id, int limit, int offset);
}
