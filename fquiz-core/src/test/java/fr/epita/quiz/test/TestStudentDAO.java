package fr.epita.quiz.test;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Student;
import fr.epita.quiz.services.CustomExtension;
import fr.epita.quiz.services.dao.StudentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestStudentDAO {

	private static final Logger LOGGER = LogManager.getLogger(TestStudentDAO.class);

	@Inject
	StudentDAO dao;

	@Test
	public void testAddStudent() throws CustomExtension {
		Student st = new Student();
		st.setS_name("st2");
		dao.create(st);

		try {
			List<Student> list = dao.getRecords(st);
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
