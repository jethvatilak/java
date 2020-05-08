package fr.epita.quiz.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.CustomExtension;
import fr.epita.quiz.services.dao.ExamDAO;
import fr.epita.quiz.services.dao.QuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestQuestionDAO {

	private static final Logger LOGGER = LogManager.getLogger(TestQuestionDAO.class);

	@Inject
	QuestionDAO dao;
	
	@Inject
	ExamDAO exdao;

	@Test
	public void testAddUser() throws CustomExtension {
		Question question = new Question();
		question.setQ_title("Your question?");
		Exam exa = new Exam();
		List<Exam> lists = exdao.getRecords(exa);
		question.setExam(lists.get(0));
		dao.create(question);

		Question q = new Question();
		Exam ex = new Exam();
		q.setExam(ex);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "A_EXAM_FK");
		dao.setParameters(map, q);
//		System.out.println("ahi ayo = " + id);
		List<Question> liste = dao.search(q);
		System.out.println("ah");
		try {
			List<Question> list = dao.getRecords(q);
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
