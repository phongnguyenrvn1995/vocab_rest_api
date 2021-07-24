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

import com.vocab.api.dao.LessonDao;
import com.vocab.api.dao.ResponseDao;
import com.vocab.api.dao.VocabDao;
import com.vocab.api.pojo.Response;
import com.vocab.api.pojo.Vocab;
import com.vocab.consts.ResponseConst;

@Path("/vocab")
public class VocabAPI {
	private final VocabDao vocabDao;
	private final LessonDao lessonDao;
	private final ResponseDao responseDao;

	public VocabAPI() {
		super();
		vocabDao = new VocabDao();
		lessonDao = new LessonDao();
		responseDao = new ResponseDao();
	}

	@Path("/gets_by_type/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vocab> getsByType(@PathParam("id") int id) {
		return vocabDao.getAllByTypeID(id);
	}

	@Path("/gets_by_lesson/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vocab> getsByLesson(@PathParam("id") int id) {
		return vocabDao.getAllByLessonID(id);
	}
	

	@Path("/gets")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vocab> gets() {
		return vocabDao.getAll();
	}

	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Vocab get(@PathParam("id") int id) {
		return vocabDao.get(id);
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		Vocab vocab = vocabDao.get(id);
		if(vocab == null)
			return responseDao.get(ResponseConst.SUCCESS);
		return vocabDao.delete(vocab) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public Response save(
			/* @FormParam("vocab_id") int vocab_id, */ 
			@FormParam("vocab_type") int vocab_type,
			@FormParam("vocab_lesson") int vocab_lesson, 
			@FormParam("vocab_en") String vocab_en,
			@FormParam("vocab_ipa") String vocab_ipa,
			@FormParam("vocab_vi") String vocab_vi,
			@FormParam("vocab_description") String vocab_description, 
			@FormParam("vocab_sound_url") String vocab_sound_url
			) {
		if(lessonDao.get(vocab_lesson) == null) { // check lesson exists or not
			return responseDao.get(ResponseConst.ERROR_LESSON_DOES_NOT_EXIST);
		}
		
		Vocab vocab = new Vocab();
		vocab.setVocab_type(vocab_type);
		vocab.setVocab_lesson(vocab_lesson);
		vocab.setVocab_en(vocab_en);
		vocab.setVocab_ipa(vocab_ipa);
		vocab.setVocab_vi(vocab_vi);
		vocab.setVocab_description(vocab_description);
		vocab.setVocab_sound_url(vocab_sound_url);
		return vocabDao.save(vocab) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(
			@FormParam("vocab_id") int vocab_id, 
			@FormParam("vocab_type") int vocab_type,
			@FormParam("vocab_lesson") int vocab_lesson, 
			@FormParam("vocab_en") String vocab_en,
			@FormParam("vocab_ipa") String vocab_ipa,
			@FormParam("vocab_vi") String vocab_vi,
			@FormParam("vocab_description") String vocab_description, 
			@FormParam("vocab_sound_url") String vocab_sound_url
			) {
		if(lessonDao.get(vocab_lesson) == null) { // check lesson exists or not
			return responseDao.get(ResponseConst.ERROR_LESSON_DOES_NOT_EXIST);
		}
		
		Vocab vocab = new Vocab();
		vocab.setVocab_id(vocab_id);
		vocab.setVocab_type(vocab_type);
		vocab.setVocab_lesson(vocab_lesson);
		vocab.setVocab_en(vocab_en);
		vocab.setVocab_ipa(vocab_ipa);
		vocab.setVocab_vi(vocab_vi);
		vocab.setVocab_description(vocab_description);
		vocab.setVocab_sound_url(vocab_sound_url);
		return vocabDao.update(vocab) ? 
				responseDao.get(ResponseConst.SUCCESS) :
					responseDao.get(ResponseConst.ERROR_DB_ERROR);
	}
}
