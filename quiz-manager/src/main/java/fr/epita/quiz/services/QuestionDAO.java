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
import fr.epita.quiz.datamodel.Question;

public class QuestionDAO extends GenericDAO<Question, Long> {
	
	@Inject
	DataSource ds;

	private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
	
	@Override
	public String getQuery() {
		return "from Question where title = :pTitle";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Question criteria) {
		parameters.put("pTitle", criteria.getTitle());
	}

	@Override
	public Class<Question> getEntityClass() {
		return Question.class;
	}
	
	public void isNull(Question question) throws ClassNullValueException {
		if(question == null) {
			throw new ClassNullValueException("question is null");
		}
	}
	
	public void isQuestionTableExist() {

		//given
		Question question = new Question();

		//when
		create(question);

		//then
		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select count(1) from QUESTIONS");
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			if (rs.getInt(1) == 0) {
				LOGGER.info("No questions available");
			}
		} catch (Exception e) {
			LOGGER.error("Some exception occured while performing count verification", e);
		}
	}
	
	public void isQuestionExist(Question question) {

		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select count(1) from QUESTIONS where QUE_ID="+question.getId());
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			if (rs.getInt(1) == 0) {
				throw new ClassNullValueException("question not found");
			}
		} catch (Exception e) {
			LOGGER.error("Some exception occured while performing count verification", e);
		}
	}
}
