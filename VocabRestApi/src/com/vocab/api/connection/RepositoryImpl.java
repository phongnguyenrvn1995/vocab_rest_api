package com.vocab.api.connection;

import java.util.List;

import com.vocab.api.base.ICourse;
import com.vocab.api.base.ILesson;
import com.vocab.api.base.IRepository;
import com.vocab.api.base.IVocab;
import com.vocab.api.base.IVocabType;

public class RepositoryImpl implements IRepository{

	@Override
	public List<ICourse> getAllCourse() {
		return CourseDBFunc.gets();
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
	public List<ILesson> getAllLesson() {
		return LessonDBFunc.gets();
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
	public List<IVocab> getAllVocab() {
		return VocabDBFunc.gets();
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
	public List<IVocabType> getAllVocabType() {
		return VocabTypeDBFunc.gets();
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

}
