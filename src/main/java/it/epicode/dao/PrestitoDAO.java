package it.epicode.dao;

import it.epicode.PrestitoEsistenteException;
import it.epicode.entities.Prestito;
import it.epicode.entities.Pubblicazione;
import jakarta.persistence.*;

import java.util.List;

public class PrestitoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PrestitoDAO(){
        emf = Persistence.createEntityManagerFactory("progetto_s3");
        em = emf.createEntityManager();
    }

    public void inserisciPrestito(Prestito p) throws PrestitoEsistenteException{
        Query query = em.createQuery("SELECT pr FROM Prestito pr WHERE pr.elementoPrestato.isbn = :elementoPrestato AND pr.dataRestituzioneEffettiva IS NULL");
        query.setParameter("elementoPrestato", p.getElementoPrestato().getIsbn());
        if (query.getResultList().size() > 0) throw new PrestitoEsistenteException("La pubblicazione selezionata è già in prestito");
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(p);
            et.commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Prestito getById(int id){
        return em.find(Prestito.class, id);
    }

    public void eliminaPrestito(int id){
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            Prestito p = getById(id);
            em.remove(p);
            et.commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Pubblicazione> elementiInPrestito(int numeroTessera){
        try {
            Query query = em.createQuery("SELECT pu FROM Pubblicazione pu INNER JOIN Prestito pr ON pr.elementoPrestato.isbn = pu.isbn WHERE pr.dataRestituzioneEffettiva IS NULL AND pr.utente.numeroTessera = :numeroTessera");
            query.setParameter("numeroTessera", numeroTessera);
            return query.getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Pubblicazione> prestitiScaduti(){
        try {
            Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL");
            return query.getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
