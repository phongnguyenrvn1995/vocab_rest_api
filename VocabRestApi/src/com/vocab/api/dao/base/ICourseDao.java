package com.vocab.api.dao.base;

import java.util.List;

public interface ICourseDao<T> extends IDao<T>{
	List<T> getAllByStatusID(String searchStr, int id);
	List<T> getAllByStatusID(String searchStr, int id, int limit, int offset);
}
