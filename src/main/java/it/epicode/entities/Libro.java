package it.epicode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "libri")
public class Libro extends Pubblicazione{
    private String autore;

    private String genere;

    public Libro(){}

    public Libro(long isbn, String titolo, int annoPubblicazione, int numeroPagine, List<Prestito> prestiti, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine, prestiti);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + getIsbn() +
                ", titolo=" + getTitolo() +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", numeroPagine=" + getNumeroPagine() +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", prestiti=" + getPrestiti() +
                '}';
    }
}
