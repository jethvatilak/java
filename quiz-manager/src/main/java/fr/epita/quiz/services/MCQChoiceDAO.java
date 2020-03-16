package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQChoice;

public class MCQChoiceDAO {

	@Inject
	SessionFactory sf;

	public void create(MCQChoice mcqchoice) {
      Session session = sf.openSession();
      session.save(mcqchoice);
	}

	public void update(MCQChoice mcqchoice) {

	}

	public void delete(MCQChoice mcqchoice) {

	}

	public List<Exam> search(MCQChoice mcqchoice) {
		return null;
	}

	public MCQChoice getById(Long id) {
		return null;
	}
}
