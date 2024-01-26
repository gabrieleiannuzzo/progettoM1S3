package it.epicode;

import it.epicode.dao.PrestitoDAO;
import it.epicode.dao.PubblicazioneDAO;
import it.epicode.dao.UtenteDAO;
import it.epicode.entities.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PubblicazioneDAO pubblicazioneDAO = new PubblicazioneDAO();
        UtenteDAO utenteDAO = new UtenteDAO();
        PrestitoDAO prestitoDAO = new PrestitoDAO();

        System.out.println(utenteDAO.getById(1));
    }
}
