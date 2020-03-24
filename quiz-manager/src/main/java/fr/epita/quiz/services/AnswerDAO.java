package fr.epita.quiz.services;

import java.util.Map;
import fr.epita.quiz.datamodel.Answer;

public class AnswerDAO extends GenericDAO<Answer, Long>{
	
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
}
