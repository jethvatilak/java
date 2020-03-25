package fr.epita.quiz.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestAnswerDAO {
	
	@Inject
//	@Named("answerQuery") 
	String query;
	
	@Test
	public void testAnswer() {
		System.out.println("test answer class");
	}

}
