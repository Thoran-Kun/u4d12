package org.example.entites;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {

    @ManyToMany
    @JoinTable(name="gara_persona", joinColumns = @JoinColumn(name="gara_id"),
    inverseJoinColumns = @JoinColumn(name="persona_id"))
     private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name="vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica(){}

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione,
                          TipoEvento tipoEvento, int numeroPartecipanti,
                          Set<Persona> atleti, Persona vincitore){
        super(titolo, dataEvento, descrizione, tipoEvento, numeroPartecipanti);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
