package br.ufg.inf.fs20211.dao;

import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.exceptions.HospedeException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class HospedeDao {
    EntityManager em;

    public HospedeDao (EntityManager em){
        this.em = em;
    }

    public List<Hospede> findAll() throws HospedeException{
        TypedQuery<Hospede> result = em.createQuery("from Hospede", Hospede.class);
        return result.getResultList();
    }

    public Hospede findById(Integer id) throws HospedeException{
        return this.em.find(Hospede.class, id);
    }

    public Hospede insert(Hospede hospede) throws HospedeException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(hospede);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            throw new HospedeException("A��o inesperada! Nenhuma linha foi inserida.");
        }
        return hospede;
    }

    public Hospede update(Hospede hospede) throws HospedeException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(hospede);
            this.em.getTransaction().commit();
            return hospede;
        } catch (Exception e) {
            throw new HospedeException("A��o inesperada! Nenhuma linha foi alterada.");
        }
    }


    public void delete(Hospede hospede) throws HospedeException {
        try {
            this.em.getTransaction().begin();
            this.em.remove(hospede);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            throw new HospedeException("A��o inesperada! Nenhuma linha foi exclu�da.");
        }
    }
}
