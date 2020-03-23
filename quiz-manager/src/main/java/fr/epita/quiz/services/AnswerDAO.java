package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epita.quiz.datamodel.Answer;

public class AnswerDAO extends GenericDAO<Answer, Long>{
	
	@Inject
	SessionFactory sf;

	public void create(Answer answer) {
      Session session = sf.openSession();
      session.save(answer);
	}

	public void update(Answer answer) {

	}

	public void delete(Answer answer) {

	}

	@Override
	public List<Answer> search(Answer criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Answer getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
