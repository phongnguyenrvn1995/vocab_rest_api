package com.vocab.api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.vocab.api.dao.ResponseDao;
import com.vocab.api.dao.VocabDao;
import com.vocab.api.dao.VocabTypeDao;
import com.vocab.api.pojo.Response;
import com.vocab.api.pojo.VocabType;
import com.vocab.consts.ResponseConst;

@Path("/vocab_type")
public class VocabTypeAPI {
	private final VocabTypeDao vocabTypeDao;
	private final VocabDao vocabDao;
	private final ResponseDao responseDao;

	public VocabTypeAPI() {
		super();
		vocabTypeDao = new VocabTypeDao();
		vocabDao = new VocabDao();
		responseDao = new ResponseDao();
	}
	
	@Path("/gets")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VocabType> gets(@DefaultValue("") @QueryParam("searchStr") String searchStr) {
		System.out.println(searchStr);
		return vocabTypeDao.getAll(searchStr);
	}

	@Path("/gets/{limit}/{offset}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VocabType> gets(@DefaultValue("") @QueryParam("searchStr") String searchStr, 
			@PathParam("limit") int limit, 
			@PathParam("offset") int offset) {
		System.out.println(searchStr);
		return vocabTypeDao.getAll(searchStr, limit, offset);
	}

	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public VocabType get(@PathParam("id") int id) {
		return vocabTypeDao.get(id);
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		VocabType vocabType = vocabTypeDao.get(id);
		if(vocabType == null)
			return responseDao.get(ResponseConst.SUCCESS);
		if(vocabDao.getAllByTypeID(id).size() > 0)
			return responseDao.get(ResponseConst.DEL_VOCAB_TYPE_ERROR_EXISTING_VOCAB_USES_TYPE);
		return vocabTypeDao.delete(vocabType) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public Response save(
			/* @FormParam("vocab_type_id") int vocab_type_id, */
			@FormParam("vocab_type_name") String vocab_type_name
			) {
		VocabType vocabType = new VocabType();
		vocabType.setVocab_type_name(vocab_type_name);
		return vocabTypeDao.save(vocabType) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(
			@DefaultValue("-1") @FormParam("vocab_type_id") int vocab_type_id,
			@FormParam("vocab_type_name") String vocab_type_name
			) {
		VocabType vocabType = new VocabType();
		vocabType.setVocab_type_id(vocab_type_id);
		vocabType.setVocab_type_name(vocab_type_name);
		return vocabTypeDao.update(vocabType) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
}
