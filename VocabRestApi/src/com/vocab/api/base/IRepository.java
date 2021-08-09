package com.vocab.api.base;

import java.util.List;

import com.vocab.api.pojo.Response;

public interface IRepository {
	List<ICourse> getAllCourse(String searchStr);
	
	List<ICourse> getAllCourse(String searchStr, int limit, int offset);

	ICourse getCourse(int id);

	boolean saveCourse(ICourse t);

	boolean updateCourse(ICourse t);

	boolean deleteCourse(ICourse t);

	List<ICourse> getAllCourseByStatusID(String searchStr, int id);
	
	List<ICourse> getAllCourseByStatusID(String searchStr, int id, int limit, int offset);

	List<ILesson> getAllLesson(String searchStr);

	List<ILesson> getAllLesson(String searchStr, int limit, int offset);

	ILesson getLesson(int id);

	boolean saveLesson(ILesson t);

	boolean updateLesson(ILesson t);

	boolean deleteLesson(ILesson t);

	List<ILesson> getAllLessonByCourseID(String searchStr, int id);
	
	List<ILesson> getAllLessonByCourseID(String searchStr, int id, int limit, int offset);

	List<ILesson> getAllLessonByStatusID(String searchStr, int id);
	
	List<ILesson> getAllLessonByStatusID(String searchStr, int id, int limit, int offset);

	List<IVocab> getAllVocab();
	
	List<IVocab> getAllVocab(int limit, int offset);

	IVocab getVocab(int id);

	boolean saveVocab(IVocab t);

	boolean updateVocab(IVocab t);

	boolean deleteVocab(IVocab t);

	List<IVocabType> getAllVocabType(String searchStr);
	
	List<IVocabType> getAllVocabType(String searchStr, int limit, int offset);

	IVocabType getVocabType(int id);

	boolean saveVocabType(IVocabType t);

	boolean updateVocabType(IVocabType t);

	boolean deleteVocabType(IVocabType t);

	List<IVocab> getAllVocabByTypeID(int id);

	List<IVocab> getAllVocabByTypeID(int id, int limit, int offset);

	List<IVocab> getAllVocabByLessonID(int id);

	List<IVocab> getAllVocabByLessonID(int id, int limit, int offset);

	public List<IStatus> getAllStatus(String searchStr);

	public List<IStatus> getAllStatus(String searchStr, int limit, int offset);

	public IStatus getStatus(int id);

	public boolean saveStatus(IStatus t);

	public boolean updateStatus(IStatus t);

	public boolean deleteStatus(IStatus t);

	public List<IResponse> getResponseAll(String searchStr);

	public List<IResponse> getResponseAll(String searchStr, int limit, int offset);

	public IResponse getResponse(int id);

	public boolean saveResponse(Response t);

	public boolean updateResponse(Response t);

	public boolean deleteResponse(Response t);
}
