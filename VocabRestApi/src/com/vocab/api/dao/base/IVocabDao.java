package com.vocab.api.dao.base;

import java.util.List;

public interface IVocabDao<T> extends IDao<T> {
	int getAllByLessonIDCount(String searchStr, int id);
	List<T> getAllByLessonID(String searchStr, int id);
	List<T> getAllByLessonID(String searchStr, int id, int limit, int offset);
	List<T> getAllByTypeID(String searchStr, int id);
	List<T> getAllByTypeID(String searchStr, int id, int limit, int offset);
}
