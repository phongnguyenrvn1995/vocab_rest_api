package com.vocab.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.vocab.api.base.ICourse;
import com.vocab.api.dao.base.ICourseDao;
import com.vocab.api.pojo.Course;

public class CourseDao extends BaseDao implements ICourseDao<Course> {


	@Override
	public List<Course> getAll() {
		List<ICourse> iList = iRepository.getAllCourse();
		List<Course> list = new ArrayList<Course>();
		for(ICourse ic : iList) {
			list.add((Course) ic);
		}
		return list;
	}
	

	@Override
	public List<Course> getAll(int limit, int offset) {
		List<ICourse> iList = iRepository.getAllCourse(limit, offset);
		List<Course> list = new ArrayList<Course>();
		for(ICourse ic : iList) {
			list.add((Course) ic);
		}
		return list;
	}


	@Override
	public Course get(int id) {
		return (Course) iRepository.getCourse(id);
	}

	@Override
	public boolean save(Course course) {
		return iRepository.saveCourse(course);
	}

	@Override
	public boolean update(Course course) {
		return iRepository.updateCourse(course);
	}

	@Override
	public boolean delete(Course course) {
		return iRepository.deleteCourse(course);
	}

	@Override
	public List<Course> getAllByStatusID(int id) {
		List<ICourse> iList = iRepository.getAllCourseByStatusID(id);
		List<Course> list = new ArrayList<Course>();
		for(ICourse ic : iList) {
			list.add((Course) ic);
		}
		return list;
	}
	
	
	
	@Override
	public List<Course> getAllByStatusID(int id, int limit, int offset) {
		List<ICourse> iList = iRepository.getAllCourseByStatusID(id, limit, offset);
		List<Course> list = new ArrayList<Course>();
		for(ICourse ic : iList) {
			list.add((Course) ic);
		}
		return list;
	}


	public static void main(String[]a) {
		System.out.println("ok");
	}
}
