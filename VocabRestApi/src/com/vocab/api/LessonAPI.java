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
import com.vocab.api.dao.VocabDao;
import com.vocab.api.pojo.Lesson;

@Path("/lesson")
public class LessonAPI {
	private final LessonDao lessonDao;	
	private final CourseDao courseDao;	
	private final VocabDao vocabDao;	
	public LessonAPI() {
		super();
		lessonDao = new LessonDao();
		courseDao = new CourseDao();
		vocabDao = new VocabDao();
	}

	@Path("/get_by_status/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lesson> getsByStatus(@PathParam("id") int id) {
		return lessonDao.getAllByStatusID(id);
	}

	@Path("/get_by_course/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lesson> getsByCourse(@PathParam("id") int id) {
		return lessonDao.getAllByCourseID(id);
	}

	@Path("/gets")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lesson> gets() {
		return lessonDao.getAll();
	}

	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Lesson get(@PathParam("id") int id) {
		return lessonDao.get(id);
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@PathParam("id") int id) {
		Lesson lesson = lessonDao.get(id);
		if(lesson == null)
			return true;
		if(vocabDao.getAllByLessonID(id).size() > 0)
			return false;
		return lessonDao.delete(lesson);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public boolean save(
			@FormParam("lesson_course") int lesson_course,
			@FormParam("lesson_name") String lesson_name,
			@FormParam("lesson_status") int lesson_status
			) {
		if(courseDao.get(lesson_course) == null)
			return false;
		Lesson lesson = new Lesson();
		lesson.setLesson_course(lesson_course);
		lesson.setLesson_name(lesson_name);
		lesson.setLesson_status(lesson_status);
		return lessonDao.save(lesson);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public boolean update(
			@FormParam("lesson_id") int lesson_id,
			@FormParam("lesson_course") int lesson_course,
			@FormParam("lesson_name") String lesson_name,
			@FormParam("lesson_status") int lesson_status
			) {
		if(courseDao.get(lesson_course) == null)
			return false;
		Lesson lesson = new Lesson();
		lesson.setLesson_id(lesson_id);
		lesson.setLesson_course(lesson_course);
		lesson.setLesson_name(lesson_name);
		lesson.setLesson_status(lesson_status);
		return lessonDao.update(lesson);
	}
}
