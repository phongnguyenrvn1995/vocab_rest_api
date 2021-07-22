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

import com.vocab.api.dao.VocabDao;
import com.vocab.api.dao.VocabTypeDao;
import com.vocab.api.pojo.VocabType;

@Path("/vocab_type")
public class VocabTypeAPI {
	private final VocabTypeDao vocabTypeDao;
	private final VocabDao vocabDao;

	public VocabTypeAPI() {
		super();
		vocabTypeDao = new VocabTypeDao();
		vocabDao = new VocabDao();
	}

	@Path("/gets")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VocabType> gets() {
		return vocabTypeDao.getAll();
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
	public boolean delete(@PathParam("id") int id) {
		VocabType vocabType = vocabTypeDao.get(id);
		if(vocabType == null)
			return true;
		if(vocabDao.getAllByTypeID(id).size() > 0)
			return false;
		return vocabTypeDao.delete(vocabType);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public boolean save(
			/* @FormParam("vocab_type_id") int vocab_type_id, */
			@FormParam("vocab_type_name") String vocab_type_name
			) {
		VocabType vocabType = new VocabType();
		vocabType.setVocab_type_name(vocab_type_name);
		return vocabTypeDao.save(vocabType);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public boolean update(
			@FormParam("vocab_type_id") int vocab_type_id,
			@FormParam("vocab_type_name") String vocab_type_name
			) {
		VocabType vocabType = new VocabType();
		vocabType.setVocab_type_id(vocab_type_id);
		vocabType.setVocab_type_name(vocab_type_name);
		return vocabTypeDao.update(vocabType);
	}
}
