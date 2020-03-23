package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import fr.epita.quiz.datamodel.Question;


public class QuestionDAO extends GenericDAO<Question, Long> {
	
	public List<Question> search(Question question){
		String titleParam = question.getTitle();
		Query searchQuery = em.createQuery("from Question where title = :pTitle");
		searchQuery.setParameter("pTitle", titleParam);
		List<Question> resultList = searchQuery.getResultList();
		return resultList;
	}
	
	public Question getById(Long id){
		return em.find(Question.class, id);
	}
}
