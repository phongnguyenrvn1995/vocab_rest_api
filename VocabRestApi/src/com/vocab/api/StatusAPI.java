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
import com.vocab.api.pojo.Response;
import com.vocab.api.pojo.Status;
import com.vocab.consts.ResponseConst;

@Path("/status")
public class StatusAPI {
	private final StatusDao statusDao;
	private final CourseDao courseDao;
	private final LessonDao lessonDao;
	private final ResponseDao responseDao;

	public StatusAPI() {
		super();
		statusDao = new StatusDao();
		courseDao = new CourseDao();
		lessonDao = new LessonDao();
		responseDao = new ResponseDao();
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
	public Response delete(@PathParam("id") int id) {
		Status status = statusDao.get(id);
		if(status == null)
			return responseDao.get(ResponseConst.SUCCESS);
		if(courseDao.getAllByStatusID(id).size() > 0)
			return responseDao.get(ResponseConst.DEL_STATUS_ERROR_EXISTING_COURSE_USES_STATUS);
		if(lessonDao.getAllByStatusID(id).size() > 0)
			return responseDao.get(ResponseConst.DEL_STATUS_ERROR_EXISTING_LESSON_USES_STATUS);
		return statusDao.delete(status) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public Response save(
			@FormParam("status_description") String status_description
			) {
		Status status = new Status();
		status.setStatus_description(status_description);
		return statusDao.save(status) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(
			@FormParam("status_id") int status_id,
			@FormParam("status_description") String status_description
			) {
		Status status = new Status();
		status.setStatus_id(status_id);
		status.setStatus_description(status_description);
		return statusDao.update(status) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
}
