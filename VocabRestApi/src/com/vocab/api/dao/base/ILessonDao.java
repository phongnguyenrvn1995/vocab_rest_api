package com.vocab.api.dao.base;

import java.util.List;

public interface ILessonDao <T> extends IDao<T> {
	int getWithFilterCount(String searchStr, int courseID, int statusID);
	List<T> getWithFilter(String searchStr, int courseID, int statusID);
	List<T> getWithFilter(String searchStr, int courseID, int statusID, int limit, int offset);
	
	int getAllByCourseIDCount(String searchStr, int id);
	List<T> getAllByCourseID(String searchStr, int id);
	List<T> getAllByCourseID(String searchStr, int id, int limit, int offset);

	int getAllByStatusIDCount(String searchStr, int id);
	List<T> getAllByStatusID(String searchStr, int id);
	List<T> getAllByStatusID(String searchStr, int id, int limit, int offset);
}
