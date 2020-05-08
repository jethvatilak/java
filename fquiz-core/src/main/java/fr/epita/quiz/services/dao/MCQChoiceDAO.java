package fr.epita.quiz.services.dao;

import java.util.Map;

import fr.epita.quiz.datamodel.MCQChoice;

public class MCQChoiceDAO extends GenericDAO<MCQChoice, Long> {

	@Override
	public String getQuery() {
		return "from " + getEntityClass().getSimpleName();
	}

	@Override
	public void setParameters(Map<String, Object> parameters, MCQChoice criteria) {
		parameters.put("title", criteria.getQuestion().getQ_id());
	}

	@Override
	public Class<MCQChoice> getEntityClass() {
		return MCQChoice.class;
	}

	@Override
	public String getSearchQuery() {
		return "from " + getEntityClass().getSimpleName() + " where QUESTION_FK = :title";
	}

}
