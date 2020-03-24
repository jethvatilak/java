package fr.epita.quiz.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestUserDAO {

	private static final Logger LOGGER = LogManager.getLogger(TestUserDAO.class);
	
	@Inject
	UserDAO dao;
	
	@Inject
	DataSource ds;
	
//	@Before
//	public void beforeTestCreate() {
//		LOGGER.info("Before Create User");
//	}
	
	@Test
	public void testCreateMethod() {

		//given
		User user = new User();

		//when
		dao.create(user);

		LOGGER.info("user login_name {}", user.getLoginName());

		//then
		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select count(1) from USERS");
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			int count = rs.getInt(1);
			Assert.assertEquals(1, count);
		} catch (Exception e) {
			LOGGER.error("Some exception occured while performing count verification", e);
		}
	}
	
//	@After
//	public void afterTestCreate() {
//		LOGGER.info("After Create User");
//	}
//	
//	@Before
//	public void beforeTestExistUser() {
//		LOGGER.info("Before Create User");
//	}
	
	public boolean testIsNull(User user) {
		if(user != null) {
			return false;
		}
		LOGGER.info("user is null");
		return true;
	}
	
//	@After
//	public void afterTestCreate() {
//		LOGGER.info("After Create User");
//	}
}
