package com.vocab.api.dao.base;

import java.util.List;

public interface IVocabDao<T> extends IDao<T> {
	List<T> getAllByLessonID(int id);
	List<T> getAllByTypeID(int id);
}
