package it.epicode.dao;

import it.epicode.entities.Pubblicazione;
import jakarta.persistence.*;

import java.util.List;

public class PubblicazioneDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PubblicazioneDAO(){
        emf = Persistence.createEntityManagerFactory("progetto_s3");
        em = emf.createEntityManager();
    }

    public void aggiungiPubblicazione (Pubblicazione pubblicazione){
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(pubblicazione);
            et.commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void eliminaPubblicazione(long isbn){
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            Pubblicazione pubblicazione = ricercaPerIsbn(isbn);
            em.remove(pubblicazione);
            et.commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Pubblicazione ricercaPerIsbn(long isbn){
        return em.find(Pubblicazione.class, isbn);
    }

    public List<Pubblicazione> ricercaPerAnnoDiPubblicazione(int annoDiPubblicazione){
        try {
            Query query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.annoPubblicazione = :anno");
            query.setParameter("anno", annoDiPubblicazione);
            return query.getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Pubblicazione> ricercaPerTitolo(String titolo){
        try {
            Query query = em.createQuery("SELECT p FROM Pubblicazione p WHERE LOWER(p.titolo) LIKE CONCAT('%', LOWER(:titolo), '%')");
            query.setParameter("titolo", titolo);
            return query.getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Pubblicazione> ricercaPerAutore(String autore){
        try {
            Query query = em.createQuery("SELECT pu FROM Pubblicazione pu WHERE LOWER(pu.autore) = LOWER(:autore)");
            query.setParameter("autore", autore);
            return query.getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
