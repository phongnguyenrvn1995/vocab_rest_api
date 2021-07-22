package com.vocab.api;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.vocab.api.dao.CourseDao;
import com.vocab.api.dao.LessonDao;
import com.vocab.api.pojo.Course;

@Path("/course")
public class CourseAPI {
	private final CourseDao courseDao;	
	private final LessonDao lessonDao;	
	public CourseAPI() {
		super();
		courseDao = new CourseDao();
		lessonDao = new LessonDao();
	}

	@Path("/gets")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> gets() {
		return courseDao.getAll();
	}

	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Course get(@PathParam("id") int id) {
		return courseDao.get(id);
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@PathParam("id") int id) {
		if(courseDao.get(id) == null)
			return true;
		if(lessonDao.getAllByCourseID(id).size() > 0) 
			return false;
		Course course = new Course();
		course.setCourse_id(id);
		return courseDao.delete(course);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public boolean save(/* @FormParam("course_id") int id, */
			@FormParam("course_name") String course_name,
			@FormParam("course_description") String course_description,
			@FormParam("course_date_creat") String course_date_creat,
			@FormParam("course_status") int course_status			
			) {
		Course course = new Course();
		course.setCourse_name(course_name);
		course.setCourse_description(course_description);
		course.setCourse_date_creat(course_date_creat);
		course.setCourse_status(course_status);
		return courseDao.save(course);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public boolean update(@FormParam("course_id") int course_id,
			@FormParam("course_name") String course_name,
			@FormParam("course_description") String course_description,
			@FormParam("course_date_creat") String course_date_creat,
			@FormParam("course_status") int course_status) {
		Course course = new Course();
		course.setCourse_id(course_id);
		course.setCourse_name(course_name);
		course.setCourse_description(course_description);
		course.setCourse_date_creat(course_date_creat);
		course.setCourse_status(course_status);
		return courseDao.update(course);
	}
}
