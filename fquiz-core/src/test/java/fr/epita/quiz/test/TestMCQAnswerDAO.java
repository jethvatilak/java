package fr.epita.quiz.test;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.MCQAnswer;
import fr.epita.quiz.services.CustomExtension;
import fr.epita.quiz.services.dao.MCQAnswerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestMCQAnswerDAO {

	private static final Logger LOGGER = LogManager.getLogger(TestMCQAnswerDAO.class);

	@Inject
	MCQAnswerDAO dao;

	@Test
	public void testAddUser() throws CustomExtension {
		MCQAnswer ans = new MCQAnswer();
		ans.setE_id(1);
		ans.setMc_id(1);
		ans.setS_id(1);
		dao.create(ans);
		
		try {
			List<MCQAnswer> list = dao.getRecords(ans);
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
