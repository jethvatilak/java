package fr.epita.quiz.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQAnswer;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.MCQQuestion;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.dao.ExamDAO;
import fr.epita.quiz.services.dao.GenericDAO;
import fr.epita.quiz.services.dao.MCQChoiceDAO;
import fr.epita.quiz.services.dao.QuestionDAO;
import fr.epita.quiz.services.dao.StudentDAO;

@Path("/exam")
public class ExamServices {
		
	@Inject
	ExamDAO dao;
	
	@Inject
	QuestionDAO qDAO;

	@Inject
	MCQChoiceDAO mcqDAO;
	
	@GET
	@Path("/get_exam/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getExam(@PathParam("id") long id) {
		Exam exam = dao.getById(id);
		return Response.ok(exam).build();
	}
	
	@GET
	@Path("/get_questionsbyexamid/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getQuestionsByExamId(@PathParam("id") long id) {
		Question q = new Question();
		Exam ex = new Exam();
		ex.setE_id(id);
		q.setExam(ex);
		List<Question> list = qDAO.search(q);
		return Response.ok(list).build();
	}
//	Map<String, Object> map = new HashMap<String, Object>();
//	map.put("title", "A_EXAM_FK");
//	qDAO.setParameters(map, q);	
	public List<Question> getQuestion(long id) {
		Question q = new Question();
		Exam ex = new Exam();
		ex.setE_id(id);
		q.setExam(ex);
		List<Question> list = qDAO.search(q);
		return list;
	}
	
	public List<MCQChoice> getMCQChoices(long id) {
		Question q = new Question();
		q.setQ_id(id);
		MCQChoice mcq = new MCQChoice();
		mcq.setQuestion(q);
		List<MCQChoice> list = mcqDAO.search(mcq);
		return list;
	}
	
	@GET
	@Path("/get_mcqchoice/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getMCQChoice(@PathParam("id") long id) {
		List<MCQQuestion> list = new ArrayList<MCQQuestion>();
		List<Question> question = getQuestion(id);
		for (Question q : question) {
			List<MCQChoice> mcq = getMCQChoices(q.getQ_id());
			MCQQuestion mcqq = new MCQQuestion();
			mcqq.setChoices(mcq);
			mcqq.setQuestion(q);
			list.add(mcqq);
		}
		
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/get_allexam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAllExams() {
		Exam ex = new Exam();
		List<Exam> list = dao.getRecords(ex);
		return Response.ok(list).build();
	}
	
	@POST
	@Path("/save_question")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response createExam(@RequestBody MCQQuestion mcqq) {
		
		MCQQuestion mcq = new MCQQuestion();
		
		Question q = mcq.getQuestion();
		qDAO.create(q);
		
		for (MCQChoice c : mcqq.getChoices()) {
			mcqDAO.create(c);
		}
		
		return Response.ok(mcqDAO).build();
	}
	
	@POST
	@Path("/create_exam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response createExam(@RequestBody Exam exam) {
		System.out.println("exam created successfully");
		
		if (exam == null || exam.getE_title().isEmpty()) {
			System.out.println("exam title is required");
		}
		
		Exam exams = new Exam();
		exams.setE_title(exam.getE_title());		
		
		return Response.ok(exams).build();
	}
	
	@PUT
	@Path("/update_exam")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response updateExam(@RequestBody Exam exam) {
		System.out.println("exam created successfully");
		
		if (exam == null || exam.getE_title().isEmpty() || exam.getE_id() == 0l) {
			System.out.println("exam title and id are required");
		}
		
		Exam exams = new Exam();
		exams.setE_title(exam.getE_title());
		
		return Response.ok(exams).build();
	}
	
//	if(examDTO == null || examDTO.getTitle() == null) {
//		return Response.ok(new GeneralError("Exam can not create")).build();
//	}
//	
//	Exam exam = new Exam();
//	exam.setTitle(examDTO.getTitle());
//	
//	examDAO.create(exam);
//	
//	examDTO.setId(exam.getId());
//	Response response = Response.ok(examDTO).build();
//	return response;
//	
//	@GET
//	@Path("/answer")
//	public Response getAnswers() {
//		return Response.status(Status.OK).entity("I am here in get answer").build();
//	}
}