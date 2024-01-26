package it.epicode.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pubblicazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenza_pubblicazioni")
    @SequenceGenerator(name = "sequenza_pubblicazioni", initialValue = 1000000000, allocationSize = 1)
    // potrei utilizzare una variabile di tipo int, ma rimarrebbe limitato a un numero massimo piuttosto vicino a 1000000000. In una situazione reale non sarebbe un approccio produttivo
    private long isbn;

    private String titolo;

    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;

    @Column(name = "numero_pagine")
    private int numeroPagine;

    @OneToMany(mappedBy = "elementoPrestato", fetch = FetchType.EAGER)
    private List<Prestito> prestiti;

    public Pubblicazione(){}

    public Pubblicazione(long isbn, String titolo, int annoPubblicazione, int numeroPagine, List<Prestito> prestiti) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.prestiti = prestiti;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Pubblicazione{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", prestiti=" + prestiti +
                '}';
    }
}
