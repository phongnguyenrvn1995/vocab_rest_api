package com.vocab.api.dao.base;

import java.util.List;

public interface ILessonDao <T> extends IDao<T> {
	List<T> getAllByCourseID(String searchStr, int id);
	List<T> getAllByCourseID(String searchStr, int id, int limit, int offset);
	List<T> getAllByStatusID(String searchStr, int id);
	List<T> getAllByStatusID(String searchStr, int id, int limit, int offset);
}
