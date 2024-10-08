package com.vocab.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.ILesson;
import com.vocab.api.dao.base.ILessonDao;
import com.vocab.api.pojo.Lesson;

public class LessonDao extends BaseDao implements ILessonDao<Lesson> {

	@Override
	public int getWithFilterCount(String searchStr, int courseID, int statusID) {
		return iRepository.getLessonFilterCount(searchStr, courseID, statusID);
	}


	@Override
	public List<Lesson> getWithFilter(String searchStr, int courseID, int statusID) {
		List<ILesson> iList = iRepository.getLessonFilter(searchStr, courseID, statusID);
		List<Lesson> list = new ArrayList<Lesson>();
		for(ILesson il : iList) {
			list.add((Lesson) il);
		}
		return list;
	}

		
	@Override
	public List<Lesson> getWithFilter(String searchStr, int courseID, int statusID, int limit, int offset) {
		List<ILesson> iList = iRepository.getLessonFilter(searchStr, courseID, statusID, limit, offset);
		List<Lesson> list = new ArrayList<Lesson>();
		for(ILesson il : iList) {
			list.add((Lesson) il);
		}
		return list;
	}
	
	@Override
	public int getAllCount(String searchStr) {
		return iRepository.getAllLessonCount(searchStr);
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
	public int getAllByCourseIDCount(String searchStr, int id) {
		return iRepository.getAllLessonByCourseIDCount(searchStr, id);
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
	public int getAllByStatusIDCount(String searchStr, int id) {
		return iRepository.getAllLessonByStatusIDCount(searchStr, id);
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
