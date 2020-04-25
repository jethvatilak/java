package fr.epita.quiz.test;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.services.CustomExtension;
import fr.epita.quiz.services.dao.MCQChoiceDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestMCQChoiceDAO {

	private static final Logger LOGGER = LogManager.getLogger(TestMCQChoiceDAO.class);

	@Inject
	MCQChoiceDAO dao;

	@Test
	public void testAddUser() throws CustomExtension {
		MCQChoice choice = new MCQChoice();
		choice.setMc_choice("first answer");
		choice.setMc_valid(1);
		choice.setQ_id(1);
		dao.create(choice);

		try {
			List<MCQChoice> list = dao.search(choice, false);
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
