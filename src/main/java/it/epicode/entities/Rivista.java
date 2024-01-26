package it.epicode.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "riviste")
public class Rivista extends Pubblicazione{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(){}

    public Rivista(long isbn, String titolo, int annoPubblicazione, int numeroPagine, List<Prestito> prestiti, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine, prestiti);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "isbn=" + getIsbn() +
                ", titolo=" + getTitolo() +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", numeroPagine=" + getNumeroPagine() +
                ", periodicita=" + periodicita +
                ", prestiti=" + getPrestiti() +
                '}';
    }
}
