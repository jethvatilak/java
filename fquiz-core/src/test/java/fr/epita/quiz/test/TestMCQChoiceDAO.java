package fr.epita.quiz.test;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.CustomExtension;
import fr.epita.quiz.services.dao.ExamDAO;
import fr.epita.quiz.services.dao.MCQChoiceDAO;
import fr.epita.quiz.services.dao.QuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestMCQChoiceDAO {

	private static final Logger LOGGER = LogManager.getLogger(TestMCQChoiceDAO.class);

	@Inject
	MCQChoiceDAO dao;
	
	@Inject
	QuestionDAO daoQ;

	@Test
	public void testAddUser() throws CustomExtension {
		MCQChoice choice = new MCQChoice();
		choice.setMc_choice("first answer");
		choice.setMc_valid(1);
		
		Question ex = new Question();
		List<Question> list1 = daoQ.getRecords(ex);
		choice.setQuestion(list1.get(0));
		dao.create(choice);

		try {
			List<MCQChoice> list = dao.getRecords(choice);
			if (list.size() > 0) {
				LOGGER.info(this.getClass().getName()+" test class successful");
			} else {
				throw new CustomExtension(this.getClass().getName()+" test not successful");
			}
		} catch (CustomExtension e) {
			throw e;
		}
	}
}
