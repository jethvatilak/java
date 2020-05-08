package fr.epita.quiz.services.dao;

import java.util.List;
import java.util.Map;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Student;

public class StudentDAO extends GenericDAO<Student, Long> {

	@Override
	public String getQuery() {
		return "from " + getEntityClass().getSimpleName();
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Student criteria) {
		parameters.put("title", criteria.getS_name());
	}

	@Override
	public Class<Student> getEntityClass() {
		return Student.class;
	}

	@Override
	public String getSearchQuery() {
		return "from " + getEntityClass().getSimpleName() + " where s_name = :title";
	}
}
