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

import com.vocab.api.dao.ResponseDao;
import com.vocab.api.pojo.Response;
import com.vocab.consts.ResponseConst;

@Path("/response")
public class ResponseAPI {

	private final ResponseDao responseDao;

	public ResponseAPI() {
		super();
		responseDao = new ResponseDao();
	}

	@Path("/gets")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Response> gets() {
		return responseDao.getAll();
	}

	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		return responseDao.get(id);
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		Response response = responseDao.get(id);
		if(response == null)
			return responseDao.get(ResponseConst.SUCCESS);
		return responseDao.delete(response) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public Response save(
			@FormParam("response_description") String response_description
			) {
		Response response = new Response();
		response.setResponse_description(response_description);
		return responseDao.save(response) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(
			@FormParam("response_id") int response_id,
			@FormParam("response_description") String response_description
			) {
		Response response = new Response();
		response.setResponse_id(response_id);
		response.setResponse_description(response_description);
		return responseDao.update(response) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
}
