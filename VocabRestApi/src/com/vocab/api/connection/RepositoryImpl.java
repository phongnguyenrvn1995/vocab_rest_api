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
	public int getAllCourseCount(String searchStr) {
		return CourseDBFunc.getsCount(searchStr);
	}

	@Override
	public List<ICourse> getAllCourse(String searchStr) {
		return CourseDBFunc.gets(searchStr);
	}
	
	@Override
	public List<ICourse> getAllCourse(String searchStr, int limit, int offset) {
		return CourseDBFunc.gets(searchStr, limit, offset);
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
	public int getAllCourseByStatusIDCount(String searchStr, int id) {
		return CourseDBFunc.getAllByStatusIDCount(searchStr, id);
	}

	@Override
	public List<ICourse> getAllCourseByStatusID(String searchStr, int id) {
		return CourseDBFunc.getAllByStatusID(searchStr, id);
	}

	@Override
	public List<ICourse> getAllCourseByStatusID(String searchStr, int id, int limit, int offset) {
		return CourseDBFunc.getAllByStatusID(searchStr, id, limit, offset);
	}
	
	@Override
	public int getLessonFilterCount(String searchStr, int courseID, int statusID) {
		return LessonDBFunc.getFilterCount(searchStr, courseID, statusID);
	}

	@Override
	public List<ILesson> getLessonFilter(String searchStr, int courseID, int statusID) {
		return LessonDBFunc.getFilter(searchStr, courseID, statusID);
	}
	
	@Override
	public List<ILesson> getLessonFilter(String searchStr, int courseID, int statusID, int limit, int offset) {
		return LessonDBFunc.getFilter(searchStr, courseID, statusID, limit, offset);
	}

	@Override
	public int getAllLessonCount(String searchStr) {
		return LessonDBFunc.getsCount(searchStr);
	}

	@Override
	public List<ILesson> getAllLesson(String searchStr) {
		return LessonDBFunc.gets(searchStr);
	}
	
	@Override
	public List<ILesson> getAllLesson(String searchStr, int limit, int offset) {
		return LessonDBFunc.gets(searchStr, limit, offset);
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
	public int getAllLessonByCourseIDCount(String searchStr, int id) {
		return LessonDBFunc.getAllByCourseIDCount(searchStr, id);
	}

	@Override
	public List<ILesson> getAllLessonByCourseID(String searchStr, int id) {
		return LessonDBFunc.getAllByCourseID(searchStr, id);
	}

	
	@Override
	public List<ILesson> getAllLessonByCourseID(String searchStr, int id, int limit, int offset) {
		return LessonDBFunc.getAllByCourseID(searchStr, id, limit, offset);
	}

	@Override
	public int getAllLessonByStatusIDCount(String searchStr, int id) {
		return LessonDBFunc.getAllByStatusIDCount(searchStr, id);
	}

	@Override
	public List<ILesson> getAllLessonByStatusID(String searchStr, int id) {
		return LessonDBFunc.getAllByStatusID(searchStr, id);
	}
	

	@Override
	public List<ILesson> getAllLessonByStatusID(String searchStr, int id, int limit, int offset) {
		return LessonDBFunc.getAllByStatusID(searchStr, id, limit, offset);
	}

	@Override
	public int getAllVocabCount(String searchStr) {
		return VocabDBFunc.getsCount(searchStr);
	}

	@Override
	public List<IVocab> getAllVocab(String searchStr) {
		return VocabDBFunc.gets(searchStr);
	}

	@Override
	public List<IVocab> getAllVocab(String searchStr, int limit, int offset) {
		return VocabDBFunc.gets(searchStr, limit, offset);
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
	public List<IVocab> getAllVocabByTypeID(String searchStr, int id) {
		return VocabDBFunc.getAllByTypeID(searchStr, id);
	}

	@Override
	public List<IVocab> getAllVocabByTypeID(String searchStr, int id, int limit, int offset) {
		return VocabDBFunc.getAllByTypeID(searchStr, id, limit, offset);
	}

	@Override
	public List<IVocab> getAllVocabByLessonID(String searchStr, int id) {
		return VocabDBFunc.getAllByLessonID(searchStr, id);
	}
	
	@Override
	public List<IVocab> getAllVocabByLessonID(String searchStr, int id, int limit, int offset) {
		return VocabDBFunc.getAllByLessonID(searchStr, id, limit, offset);
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
