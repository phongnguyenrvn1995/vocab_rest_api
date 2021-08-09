package com.vocab.api.connection;

import java.util.List;

import com.vocab.api.base.ICourse;
import com.vocab.api.base.ILesson;
import com.vocab.api.base.IRepository;
import com.vocab.api.base.IResponse;
import com.vocab.api.base.IStatus;
import com.vocab.api.base.IVocab;
import com.vocab.api.base.IVocabType;
import com.vocab.api.pojo.Response;

public class RepositoryImpl implements IRepository{

	@Override
	public List<ICourse> getAllCourse() {
		return CourseDBFunc.gets();
	}
	
	@Override
	public List<ICourse> getAllCourse(int limit, int offset) {
		return CourseDBFunc.gets(limit, offset);
	}

	@Override
	public ICourse getCourse(int id) {
		return CourseDBFunc.get(id);
	}

	@Override
	public boolean saveCourse(ICourse object) {
		return CourseDBFunc.save(object);
	}

	@Override
	public boolean updateCourse(ICourse object) {
		return CourseDBFunc.update(object);
	}

	@Override
	public boolean deleteCourse(ICourse object) {
		return CourseDBFunc.delete(object);
	}

		
	@Override
	public List<ICourse> getAllCourseByStatusID(int id) {
		return CourseDBFunc.getAllByStatusID(id);
	}

	@Override
	public List<ICourse> getAllCourseByStatusID(int id, int limit, int offset) {
		return CourseDBFunc.getAllByStatusID(id, limit, offset);
	}

	@Override
	public List<ILesson> getAllLesson() {
		return LessonDBFunc.gets();
	}
	
	@Override
	public List<ILesson> getAllLesson(int limit, int offset) {
		return LessonDBFunc.gets(limit, offset);
	}

	@Override
	public ILesson getLesson(int id) {
		return LessonDBFunc.get(id);
	}

	@Override
	public boolean saveLesson(ILesson object) {
		return LessonDBFunc.save(object);
	}

	@Override
	public boolean updateLesson(ILesson object) {
		return LessonDBFunc.update(object);
	}

	@Override
	public boolean deleteLesson(ILesson object) {
		return LessonDBFunc.delete(object);
	}
	

	@Override
	public List<ILesson> getAllLessonByCourseID(int id) {
		return LessonDBFunc.getAllByCourseID(id);
	}

	
	@Override
	public List<ILesson> getAllLessonByCourseID(int id, int limit, int offset) {
		return LessonDBFunc.getAllByCourseID(id, limit, offset);
	}

	@Override
	public List<ILesson> getAllLessonByStatusID(int id) {
		return LessonDBFunc.getAllByStatusID(id);
	}
	

	@Override
	public List<ILesson> getAllLessonByStatusID(int id, int limit, int offset) {
		return LessonDBFunc.getAllByStatusID(id, limit, offset);
	}

	@Override
	public List<IVocab> getAllVocab() {
		return VocabDBFunc.gets();
	}

	@Override
	public List<IVocab> getAllVocab(int limit, int offset) {
		return VocabDBFunc.gets(limit, offset);
	}

	@Override
	public IVocab getVocab(int id) {
		return VocabDBFunc.get(id);
	}

	@Override
	public boolean saveVocab(IVocab object) {
		return VocabDBFunc.save(object);
	}

	@Override
	public boolean updateVocab(IVocab object) {
		return VocabDBFunc.update(object);
	}

	@Override
	public boolean deleteVocab(IVocab object) {
		return VocabDBFunc.delete(object);
	}

	@Override
	public List<IVocabType> getAllVocabType(String searchStr) {
		return VocabTypeDBFunc.gets(searchStr);
	}

	@Override
	public List<IVocabType> getAllVocabType(String searchStr, int limit, int offset) {
		return VocabTypeDBFunc.gets(searchStr, limit, offset);
	}

	@Override
	public IVocabType getVocabType(int id) {
		return VocabTypeDBFunc.get(id);
	}

	@Override
	public boolean saveVocabType(IVocabType object) {
		return VocabTypeDBFunc.save(object);
	}

	@Override
	public boolean updateVocabType(IVocabType object) {
		return VocabTypeDBFunc.update(object);
	}

	@Override
	public boolean deleteVocabType(IVocabType object) {
		return VocabTypeDBFunc.delete(object);
	}

	@Override
	public List<IVocab> getAllVocabByTypeID(int id) {
		return VocabDBFunc.getAllByTypeID(id);
	}

	@Override
	public List<IVocab> getAllVocabByTypeID(int id, int limit, int offset) {
		return VocabDBFunc.getAllByTypeID(id, limit, offset);
	}

	@Override
	public List<IVocab> getAllVocabByLessonID(int id) {
		return VocabDBFunc.getAllByLessonID(id);
	}
	
	@Override
	public List<IVocab> getAllVocabByLessonID(int id, int limit, int offset) {
		return VocabDBFunc.getAllByLessonID(id, limit, offset);
	}

	@Override
	public List<IStatus> getAllStatus(String searchStr) {
		return StatusDBFunc.getAll(searchStr);
	}

	@Override
	public List<IStatus> getAllStatus(String searchStr, int limit, int offset) {
		return StatusDBFunc.getAll(searchStr, limit, offset);
	}

	@Override
	public IStatus getStatus(int id) {
		return StatusDBFunc.get(id);
	}

	@Override
	public boolean saveStatus(IStatus t) {
		return StatusDBFunc.save(t);
	}

	@Override
	public boolean updateStatus(IStatus t) {
		return StatusDBFunc.update(t);
	}

	@Override
	public boolean deleteStatus(IStatus t) {
		return StatusDBFunc.delete(t);
	}

	@Override
	public List<IResponse> getResponseAll(String searchStr) {
		return ResponseDBFunc.getAll(searchStr);
	}

	@Override
	public List<IResponse> getResponseAll(String searchStr, int limit, int offset) {
		return ResponseDBFunc.getAll(searchStr, limit, offset);
	}

	@Override
	public IResponse getResponse(int id) {
		return ResponseDBFunc.get(id);
	}

	@Override
	public boolean saveResponse(Response t) {
		return ResponseDBFunc.save(t);
	}

	@Override
	public boolean updateResponse(Response t) {
		return ResponseDBFunc.update(t);
	}

	@Override
	public boolean deleteResponse(Response t) {
		return ResponseDBFunc.delete(t);
	}
}
