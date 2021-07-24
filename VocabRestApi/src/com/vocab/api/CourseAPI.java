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
import com.vocab.api.dao.ResponseDao;
import com.vocab.api.dao.StatusDao;
import com.vocab.api.pojo.Course;
import com.vocab.api.pojo.Response;
import com.vocab.consts.ResponseConst;

@Path("/course")
public class CourseAPI {
	private final CourseDao courseDao;	
	private final LessonDao lessonDao;	
	private final StatusDao statusDao;	
	private final ResponseDao responseDao;	
	public CourseAPI() {
		super();
		courseDao = new CourseDao();
		lessonDao = new LessonDao();
		statusDao = new StatusDao();
		responseDao = new ResponseDao();
	}

	@Path("/get_by_status/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getsByStatus(@PathParam("id") int id) {
		return courseDao.getAll();
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
	public Response delete(@PathParam("id") int id) {
		if(courseDao.get(id) == null)
			return responseDao.get(ResponseConst.SUCCESS);
		if(lessonDao.getAllByCourseID(id).size() > 0) 
			return responseDao.get(ResponseConst.DEL_COURSE_ERROR_EXISTING_LESSON_IN_COURSE);
		Course course = new Course();
		course.setCourse_id(id);
		return courseDao.delete(course) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public Response save(/* @FormParam("course_id") int id, */
			@FormParam("course_name") String course_name,
			@FormParam("course_description") String course_description,
			@FormParam("course_date_creat") String course_date_creat,
			@FormParam("course_status") int course_status			
			) {
		if(statusDao.get(course_status) == null)
			return responseDao.get(ResponseConst.ERROR_STATUS_DOES_NOT_EXIST);
		Course course = new Course();
		course.setCourse_name(course_name);
		course.setCourse_description(course_description);
		course.setCourse_date_creat(course_date_creat);
		course.setCourse_status(course_status);
		return courseDao.save(course) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(@FormParam("course_id") int course_id,
			@FormParam("course_name") String course_name,
			@FormParam("course_description") String course_description,
			@FormParam("course_date_creat") String course_date_creat,
			@FormParam("course_status") int course_status) {
		if(statusDao.get(course_status) == null)
			return responseDao.get(ResponseConst.ERROR_STATUS_DOES_NOT_EXIST);
		Course course = new Course();
		course.setCourse_id(course_id);
		course.setCourse_name(course_name);
		course.setCourse_description(course_description);
		course.setCourse_date_creat(course_date_creat);
		course.setCourse_status(course_status);
		return courseDao.update(course)? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
}
