package fr.epita.quiz.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.ClassNullValueException;

public class AnswerDAO extends GenericDAO<Answer, Long>{
	
	@Inject
	DataSource ds;
	
	private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
	
	@Override
	public String getQuery() {
		return "from Answer";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Answer criteria) {
		return;
	}

	@Override
	public Class<Answer> getEntityClass() {
		// TODO Auto-generated method stub
		return Answer.class;
	}
	
	public void isNull(Answer answer) throws ClassNullValueException {
		if(answer == null) {
			throw new ClassNullValueException("answer is null");
		}
	}
	
	public void isAnswerTableExist() {

		//given
		Answer answer = new Answer();

		//when
		create(answer);

		//then
		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select count(1) from ANSWERS");
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			if (rs.getInt(1) == 0) {
				LOGGER.info("No answers available");
			}
		} catch (Exception e) {
			LOGGER.error("Some exception occured while performing count verification", e);
		}
	}
	
	public void isAnswerExist(Answer answer) {

		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select count(1) from ANSWERS where ANS_ID="+answer.getId());
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			if (rs.getInt(1) == 0) {
				throw new ClassNullValueException("answer not found");
			}
		} catch (Exception e) {
			LOGGER.error("Some exception occured while performing count verification", e);
		}
	}
}
