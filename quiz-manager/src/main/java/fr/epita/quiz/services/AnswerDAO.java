package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epita.quiz.datamodel.Answer;

public class AnswerDAO {
	
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

	public List<Answer> search(Answer answer) {
		return null;
	}

	public Answer getById(Long id) {
		return null;
	}
}
