/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.dao;

import co.com.adminsol.utilidades.Log;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author MARA
 * @param <T>
 */
public abstract class GenericDAO<T> extends Log{

    private final static String UNIT_NAME = "ADMIN_SOL_PREST-ejbPU";

    @PersistenceContext(unitName = UNIT_NAME, type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected void save(T entity) {
        em.persist(entity);
    }

    protected void delete(T entity) {
        T entityToBeRemoved = em.merge(entity);

        em.remove(entityToBeRemoved);
    }

    protected T update(T entity) {
        return em.merge(entity);
    }

    protected T find(Object entityID) {
        return em.find(entityClass, entityID);
    }
    
    protected T find(String entityID) {
        return em.find(entityClass, entityID);
    }

    protected T find(Integer entityID) {
        return em.find(entityClass, entityID);
    }

 // Using the unchecked because JPA does not have a
    // em.getCriteriaBuilder().createQuery()<T> method
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

 // Using the unchecked because JPA does not have a
    // ery.getSingleResult()<T> method
    @SuppressWarnings("unchecked")
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;

        try {
            Query query = em.createNamedQuery(namedQuery);

            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = (T) query.getSingleResult();

        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    protected List<T> executeQueryListResult(String namedQuery, Map<String, Object> parameters) {
        List<T> result = null;

        try {
            Query query = em.createNamedQuery(namedQuery);

            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = (List<T>) query.getResultList();

        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }
    
    @SuppressWarnings("unchecked")
    protected int executeQueryUpdate(String namedQuery, Map<String, Object> parameters) {
        int result = -2;

        try {
            Query query = em.createNamedQuery(namedQuery);

            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = query.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }
    
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {

        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}
