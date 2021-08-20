package com.vocab.api.dao.base;

import java.util.List;

public interface ILessonDao <T> extends IDao<T> {
	int getAllByCourseIDCount(String searchStr, int id);
	List<T> getAllByCourseID(String searchStr, int id);
	List<T> getAllByCourseID(String searchStr, int id, int limit, int offset);

	int getAllByStatusIDCount(String searchStr, int id);
	List<T> getAllByStatusID(String searchStr, int id);
	List<T> getAllByStatusID(String searchStr, int id, int limit, int offset);
}
