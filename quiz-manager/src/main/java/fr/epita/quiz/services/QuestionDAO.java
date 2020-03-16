package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import fr.epita.quiz.datamodel.Question;


public class QuestionDAO {

	@Inject
	SessionFactory sf;

	public void create(Question question) {
      Session session = sf.openSession();
      session.save(question);
	}

	public void update(Question question) {

	}

	public void delete(Question question) {

	}

	public List<Question> search(Question question) {
		return null;
	}

	public Question getById(Long id) {
		return null;
	}

}
