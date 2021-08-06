package com.vocab.api.dao.base;

import java.util.List;

public interface IVocabDao<T> extends IDao<T> {
	List<T> getAllByLessonID(int id);
	List<T> getAllByLessonID(int id, int limit, int offset);
	List<T> getAllByTypeID(int id);
	List<T> getAllByTypeID(int id, int limit, int offset);
}
