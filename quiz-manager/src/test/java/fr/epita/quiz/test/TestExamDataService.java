package fr.epita.quiz.test;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.*;
import fr.epita.quiz.services.*;
import fr.epita.quiz.services.business.ExamDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestExamDataService {

	@Inject
	ExamDataService ds;
	
	@Inject
	AnswerDAO answerDao;
	
	@Inject
	UserDAO userDao;
	
	@Inject
	QuestionDAO questionDao;
	
	@Test
	public void testAnswerToQuestion()  {
		//given
		User user = new User();
		user.setLoginName("gddfgfdgdf");
		user.setEmail("test@test.com");
		userDao.create(user);
		
		Question question = new Question();
		question.setTitle("What is Java?");
		questionDao.create(question);
		
		//when
		Answer answer = new Answer();
		answer.setContent("I don't know");
		
		try {
			ds.answerToQuestion(user, question, answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//then
		Answer fetchedAnswer = answerDao.getById(answer.getId());
		//assertEquals(fetchedAnswer.getUser().getLoginName(), user.getLoginName()); 	
	}
}
