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
import fr.epita.quiz.services.CustomExtension;
import fr.epita.quiz.services.dao.ExamDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestExamDAO {
	
	private static final Logger LOGGER = LogManager.getLogger(TestExamDAO.class);

	@Inject
	ExamDAO dao;

	@Test
	public void testAddExam() throws CustomExtension {

		Exam exam = new Exam();
		exam.setE_title("admin");
		dao.create(exam);

		try {
			List<Exam> list = dao.getRecords(exam);
			if (list.size() > 0) {
				LOGGER.info(this.getClass().getSimpleName()+" test class successful");
			} else {
				throw new CustomExtension(this.getClass().getSimpleName()+" test not successful");
			}
		} catch (CustomExtension e) {
			throw e;
		}
	}
}
