package org.example.entites;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id //OBBLIGATORIO. Corrisponderà alla pirma colonna delle PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //titolo
    @Column(name = "titolo", nullable = false, length = 40)
    private String titolo;
    //data Evento
    @Column(name = "dataEvento", nullable = false)
    private LocalDate dataEvento;
    //descrizione
    @Column(name = "descrizione", nullable = false, length = 100)
    private String descrizione;
    //tipo EVENTO
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    //numero massimo Partecipanti
    @Column(name = "numeroPartecipanti")
    private int numeroPartecipanti;

    //COSTRUTTORE VUOTO PER POTER PERMETTERE DI CREARE GLI OGGETTI
    public Evento(){}

    //COSTRUTTORE VERO E PROPRIO
    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroPartecipanti){
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroPartecipanti = numeroPartecipanti;
    }

    //GETTER E SETTER

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroPartecipanti() {
        return numeroPartecipanti;
    }

    public void setNumeroPartecipanti(int numeroPartecipanti) {
        this.numeroPartecipanti = numeroPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroPartecipanti=" + numeroPartecipanti +
                '}';
    }
}
