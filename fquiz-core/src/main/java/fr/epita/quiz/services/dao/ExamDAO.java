package fr.epita.quiz.services.dao;

import java.util.Map;

import fr.epita.quiz.datamodel.Exam;

public class ExamDAO extends GenericDAO<Exam, Long> {

	@Override
	public String getQuery() {
		return "from " + getEntityClass().getSimpleName();
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Exam criteria) {
		parameters.put("title", criteria.getE_title());
	}

	@Override
	public Class<Exam> getEntityClass() {
		return Exam.class;
	}

	@Override
	public String getSearchQuery() {
		return "from " + getEntityClass().getSimpleName() + " where e_title = :title";
	}
}
