package fr.epita.quiz.services.dao;

import java.util.Map;

import fr.epita.quiz.datamodel.MCQAnswer;

public class MCQAnswerDAO extends GenericDAO<MCQAnswer, Long> {

	@Override
	public String getQuery() {
		return "from " + getEntityClass().getSimpleName();
	}

	@Override
	public void setParameters(Map<String, Object> parameters, MCQAnswer criteria) {
		parameters.put("e_id", criteria.getE_id());
		parameters.put("mc_id", criteria.getMc_id());
		parameters.put("s_id", criteria.getS_id());
	}

	@Override
	public Class<MCQAnswer> getEntityClass() {
		return MCQAnswer.class;
	}

	@Override
	public String getSearchQuery() {
		return "from " + getEntityClass().getSimpleName() + " where e_id = :e_id AND mc_id = :mc_id AND s_id = :s_id";
	}

}
