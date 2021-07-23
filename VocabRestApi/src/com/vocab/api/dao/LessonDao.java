package com.vocab.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.ILesson;
import com.vocab.api.dao.base.ILessonDao;
import com.vocab.api.pojo.Lesson;

public class LessonDao extends AbsDao implements ILessonDao<Lesson> {

	@Override
	public List<Lesson> getAll() {
		List<ILesson> iList = iRepository.getAllLesson();
		List<Lesson> list = new ArrayList<Lesson>();
		for(ILesson il : iList) {
			list.add((Lesson) il);
		}
		return list;
	}

	@Override
	public Lesson get(int id) {
		return (Lesson) iRepository.getLesson(id);
	}

	@Override
	public boolean save(Lesson lesson) {
		return iRepository.saveLesson(lesson);
	}

	@Override
	public boolean update(Lesson lesson) {
		return iRepository.updateLesson(lesson);
	}

	@Override
	public boolean delete(Lesson lesson) {
		return iRepository.deleteLesson(lesson);
	}

	@Override
	public List<Lesson> getAllByCourseID(int id) {
		List<ILesson> iList = iRepository.getAllLessonByCourseID(id);
		List<Lesson> list = new ArrayList<Lesson>();
		for(ILesson il : iList) {
			list.add((Lesson) il);
		}
		return list;
	}

	@Override
	public List<Lesson> getAllByStatusID(int id) {
		List<ILesson> iList = iRepository.getAllLessonByStatusID(id);
		List<Lesson> list = new ArrayList<Lesson>();
		for(ILesson il : iList) {
			list.add((Lesson) il);
		}
		return list;
	}
	
	
}
