package com.vocab.api.dao.base;

import java.util.List;

public interface ILessonDao <T> extends IDao<T> {
	List<T> getAllByCourseID(int id);
	List<T> getAllByCourseID(int id, int limit, int offset);
	List<T> getAllByStatusID(int id);
	List<T> getAllByStatusID(int id, int limit, int offset);
}
