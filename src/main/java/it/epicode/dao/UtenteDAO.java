package it.epicode.dao;

import it.epicode.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UtenteDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public UtenteDAO(){
        emf = Persistence.createEntityManagerFactory("progetto_s3");
        em = emf.createEntityManager();
    }

    public void inserisciUtente(Utente u){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(u);
        et.commit();
    }

    public Utente getById(int id){
        return em.find(Utente.class, id);
    }

    public void eliminaUtente(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Utente u = getById(id);
        em.remove(u);
        et.commit();
    }
}
