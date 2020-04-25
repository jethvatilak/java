package fr.epita.quiz.services.dao;

import java.util.Map;

import fr.epita.quiz.datamodel.Question;

public class QuestionDAO extends GenericDAO<Question, Long> {

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Question criteria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<Question> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSearchQuery() {
		// TODO Auto-generated method stub
		return null;
	}

}
