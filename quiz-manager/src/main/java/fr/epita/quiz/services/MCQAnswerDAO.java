package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epita.quiz.datamodel.MCQAnswer;

public class MCQAnswerDAO {

	@Inject
	SessionFactory sf;

	public void create(MCQAnswer mcqanswer) {
      Session session = sf.openSession();
      session.save(mcqanswer);
	}

	public void update(MCQAnswer mcqanswer) {

	}

	public void delete(MCQAnswer mcqanswer) {

	}

	public List<MCQAnswer> search(MCQAnswer mcqanswer) {
		return null;
	}

	public MCQAnswer getById(Long id) {
		return null;
	}
}
