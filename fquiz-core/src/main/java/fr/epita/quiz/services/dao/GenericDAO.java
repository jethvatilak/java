package fr.epita.quiz.services.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

public abstract class GenericDAO<T, I> {

	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void create(T entity) {
		em.persist(entity);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void update(T entity) {
		em.merge(entity);
	}
	
	public abstract String getQuery();
	
	public abstract String getSearchQuery();

	public abstract void setParameters(Map<String, Object> parameters, T criteria);
	
	public abstract Class<T> getEntityClass();
		
	public List<T> search(T criteria, boolean isSearch) {
		Query searchQuery = isSearch ? em.createQuery(getSearchQuery()) : em.createQuery(getQuery());
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		setParameters(parameters, criteria);
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			searchQuery.setParameter(entry.getKey(), entry.getValue());
		}
		return searchQuery.getResultList();
	}

	public T getById(I id) {
		return em.find(getEntityClass(), id);
	}
}
