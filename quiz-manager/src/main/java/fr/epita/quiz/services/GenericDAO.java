package fr.epita.quiz.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

public abstract class GenericDAO<T,I> {

	@PersistenceContext
	protected EntityManager em;
	
	@Transactional(value = TxType.REQUIRED)
	public void create(T entity) {	
		em.persist(entity);
	}
	
	public abstract List<T> search(T criteria);
	public abstract T getById(I id);
}
