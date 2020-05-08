package fr.epita.quiz.services.dao;

import java.util.List;
import java.util.Map;

import fr.epita.quiz.datamodel.Question;

public class QuestionDAO extends GenericDAO<Question, Long> {

	@Override
	public String getQuery() {
		return "from " + getEntityClass().getSimpleName();
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Question criteria) {
		parameters.put("title", criteria.getExam().getE_id());
	}

	@Override
	public Class<Question> getEntityClass() {
		return Question.class;
	}

	@Override
	public String getSearchQuery() {
		return "from " + getEntityClass().getSimpleName() + " where A_EXAM_FK = :title";
	}
}
