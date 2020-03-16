package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epita.quiz.datamodel.Student;

public class StudentDAO {

	@Inject
	SessionFactory sf;

	public void create(Student student) {
      Session session = sf.openSession();
      session.save(student);
	}

	public void update(Student student) {

	}

	public void delete(Student student) {

	}

	public List<Student> search(Student student) {
		return null;
	}

	public Student getById(Long id) {
		return null;
	}
}
