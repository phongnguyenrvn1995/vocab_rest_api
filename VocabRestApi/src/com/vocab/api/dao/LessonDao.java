package com.vocab.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.ILesson;
import com.vocab.api.dao.base.ILessonDao;
import com.vocab.api.pojo.Lesson;

public class LessonDao extends BaseDao implements ILessonDao<Lesson> {

	@Override
	public int getAllCount(String searchStr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Lesson> getAll(String searchStr) {
		List<ILesson> iList = iRepository.getAllLesson(searchStr);
		List<Lesson> list = new ArrayList<Lesson>();
		for(ILesson il : iList) {
			list.add((Lesson) il);
		}
		return list;
	}

	@Override
	public List<Lesson> getAll(String searchStr, int limit, int offset) {
		List<ILesson> iList = iRepository.getAllLesson(searchStr, limit, offset);
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
	public List<Lesson> getAllByCourseID(String searchStr, int id) {
		List<ILesson> iList = iRepository.getAllLessonByCourseID(searchStr, id);
		List<Lesson> list = new ArrayList<Lesson>();
		for(ILesson il : iList) {
			list.add((Lesson) il);
		}
		return list;
	}
	
	

	@Override
	public List<Lesson> getAllByCourseID(String searchStr, int id, int limit, int offset) {
		List<ILesson> iList = iRepository.getAllLessonByCourseID(searchStr, id, limit, offset);
		List<Lesson> list = new ArrayList<Lesson>();
		for(ILesson il : iList) {
			list.add((Lesson) il);
		}
		return list;
	}

	@Override
	public List<Lesson> getAllByStatusID(String searchStr, int id) {
		List<ILesson> iList = iRepository.getAllLessonByStatusID(searchStr, id);
		List<Lesson> list = new ArrayList<Lesson>();
		for(ILesson il : iList) {
			list.add((Lesson) il);
		}
		return list;
	}

	@Override
	public List<Lesson> getAllByStatusID(String searchStr, int id, int limit, int offset) {
		List<ILesson> iList = iRepository.getAllLessonByStatusID(searchStr, id, limit, offset);
		List<Lesson> list = new ArrayList<Lesson>();
		for(ILesson il : iList) {
			list.add((Lesson) il);
		}
		return list;
	}
	
	public static void main(String[]a) {
		System.out.println("ok");
	}
	
}
