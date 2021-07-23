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
import com.vocab.api.dao.StatusDao;
import com.vocab.api.pojo.Status;

@Path("/status")
public class StatusAPI {
	private final StatusDao statusDao;
	private final CourseDao courseDao;
	private final LessonDao lessonDao;

	public StatusAPI() {
		super();
		statusDao = new StatusDao();
		courseDao = new CourseDao();
		lessonDao = new LessonDao();
	}

	@Path("/gets")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Status> gets() {
		return statusDao.getAll();
	}

	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Status get(@PathParam("id") int id) {
		return statusDao.get(id);
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@PathParam("id") int id) {
		Status status = statusDao.get(id);
		if(status == null)
			return true;
		if(courseDao.getAllByStatusID(id).size() > 0)
			return false;
		if(lessonDao.getAllByStatusID(id).size() > 0)
			return false;
		return statusDao.delete(status);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public boolean save(
			@FormParam("status_description") String status_description
			) {
		Status status = new Status();
		status.setStatus_description(status_description);
		return statusDao.save(status);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public boolean update(
			@FormParam("status_id") int status_id,
			@FormParam("status_description") String status_description
			) {
		Status status = new Status();
		status.setStatus_id(status_id);
		status.setStatus_description(status_description);
		return statusDao.update(status);
	}
}
