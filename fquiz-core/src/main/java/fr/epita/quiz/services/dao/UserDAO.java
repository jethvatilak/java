package fr.epita.quiz.services.dao;

import java.util.Map;

import fr.epita.quiz.datamodel.User;

public class UserDAO extends GenericDAO<User, Long> {

	@Override
	public String getQuery() {
		return "from User";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, User criteria) {
		parameters.put("title", criteria.getU_name());
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

	@Override
	public String getSearchQuery() {
		return "from User where u_name = :title";
	}

}
