package org.example.entites;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "partecipazioni")
public class Partecipazioni {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private StatoPartecipazione statoPartecipazione;

    public Partecipazioni(){}

    public Partecipazioni(Persona persona, Evento evento, StatoPartecipazione statoPartecipazione){
        this.persona = persona;
        this.evento = evento;
        this.statoPartecipazione = statoPartecipazione;
    }

    public UUID getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStatoPartecipazione() {
        return statoPartecipazione;
    }

    public void setStatoPartecipazione(StatoPartecipazione statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }

    @Override
    public String toString() {
        return "Partecipazioni{" +
                "id=" + id +
                ", statoPartecipazione=" + statoPartecipazione +
                '}';
    }
}
