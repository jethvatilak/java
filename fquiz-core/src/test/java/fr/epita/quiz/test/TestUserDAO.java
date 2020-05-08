package fr.epita.quiz.test;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.CustomExtension;
import fr.epita.quiz.services.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestUserDAO {

	private static final Logger LOGGER = LogManager.getLogger(TestUserDAO.class);

	@Inject
	UserDAO dao;

	@Test
	public void testAddUser() throws CustomExtension {
		User user = new User();
		user.setU_name("Tilak");
		user.setU_pwd("1234");
		dao.create(user);

		try {
			List<User> list = dao.getRecords(user);
			if (list.size() > 0) {
				LOGGER.info(this.getClass().getName()+" test class successful");
			} else {
				throw new CustomExtension(this.getClass().getName()+" test not successful");
			}
		} catch (CustomExtension e) {
			throw e;
		}
	}

//	@Test
//	public void testUpdateUser() throws CustomExtension {
//		User user = new User();
//		user.setU_name("jsn");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("title", "u_name");
//		dao.setParameters(map, user);
//		List<User> list = dao.search(user, true);
//	
//		Assert.assertEquals(1, list.size());
//	}
}
