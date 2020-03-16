package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epita.quiz.datamodel.Exam;

public class ExamDAO {

	@Inject
	SessionFactory sf;
	
	public void create(Exam exam) {
      Session session = sf.openSession();
      session.save(exam);
	}

	public void update(Exam exam) {

	}

	public void delete(Exam exam) {

	}

	public List<Exam> search(Exam exam) {
		return null;
	}

	public Exam getById(Long id) {
		return null;
	}
}
