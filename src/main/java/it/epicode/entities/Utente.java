package it.epicode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_tessera")
    private int numeroTessera;

    private String nome;

    private String cognome;

    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;

    @OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<Prestito> prestiti;

    public Utente(){}

    public Utente(int numeroTessera, String nome, String cognome, LocalDate dataDiNascita, List<Prestito> prestiti) {
        this.numeroTessera = numeroTessera;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.prestiti = prestiti;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", prestiti=" + prestiti +
                '}';
    }
}
