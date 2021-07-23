package com.vocab.api.base;

import java.util.List;

public interface IRepository {
	List<ICourse> getAllCourse();

	ICourse getCourse(int id);

	boolean saveCourse(ICourse t);

	boolean updateCourse(ICourse t);

	boolean deleteCourse(ICourse t);

	List<ICourse> getAllCourseByStatusID(int id);

	List<ILesson> getAllLesson();

	ILesson getLesson(int id);

	boolean saveLesson(ILesson t);

	boolean updateLesson(ILesson t);

	boolean deleteLesson(ILesson t);

	List<ILesson> getAllLessonByCourseID(int id);

	List<ILesson> getAllLessonByStatusID(int id);

	List<IVocab> getAllVocab();

	IVocab getVocab(int id);

	boolean saveVocab(IVocab t);

	boolean updateVocab(IVocab t);

	boolean deleteVocab(IVocab t);

	List<IVocabType> getAllVocabType();

	IVocabType getVocabType(int id);

	boolean saveVocabType(IVocabType t);

	boolean updateVocabType(IVocabType t);

	boolean deleteVocabType(IVocabType t);
	
	List<IVocab> getAllVocabByTypeID(int id);
	
	List<IVocab> getAllVocabByLessonID(int id);
	
	
	public List<IStatus> getAllStatus();

	
	public IStatus getStatus(int id);

	
	public boolean saveStatus(IStatus t);

	
	public boolean updateStatus(IStatus t);

	
	public boolean deleteStatus(IStatus t);
}
