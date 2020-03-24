package fr.epita.quiz.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epita.quiz.datamodel.ClassNullValueException;
import fr.epita.quiz.datamodel.User;

public class UserDAO extends GenericDAO<User, String> {
	
	@Inject
	DataSource ds;

	private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
	
	@Override
	public String getQuery() {
		return "from User where email = :pEmail ";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, User criteria) {
		parameters.put("pEmail",criteria.getEmail());
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
	
	public void isNull(User user) throws ClassNullValueException {
		if(user == null) {
			throw new ClassNullValueException("user is null");
		}
	}
	
	public void isUserTableExist() {

		//given
		User user = new User();

		//when
		create(user);

		//then
		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select count(1) from USERS");
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			if (rs.getInt(1) == 0) {
				LOGGER.info("No users available");
			}
		} catch (Exception e) {
			LOGGER.error("Some exception occured while performing count verification", e);
		}
	}
	
	public void isUserExist(User user) {

		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select count(1) from USERS where USER_LOGIN="+user.getLoginName());
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			if (rs.getInt(1) == 0) {
				throw new ClassNullValueException("user not found");
			}
		} catch (Exception e) {
			LOGGER.error("Some exception occured while performing count verification", e);
		}
	}
}
