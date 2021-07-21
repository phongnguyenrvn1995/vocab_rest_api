package com.vocab.api;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.vocab.api.dao.CourseDao;
import com.vocab.api.pojo.Course;

@Path("/course")
public class CourseAPI {
	private final CourseDao courseDao;	
	public CourseAPI() {
		super();
		courseDao = new CourseDao();
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
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@PathParam("id") int id) {
		Course c = new Course();
		c.setCourse_id(id);
		return courseDao.delete(c);
	}
}
