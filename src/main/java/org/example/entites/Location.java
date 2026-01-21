package org.example.entites;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "locations")
public class Location {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "nome")
    private String nome;
    @Column(name ="città", nullable = false)
    private String città;

    @OneToMany(mappedBy = "location")
    private List<Evento> evento;

    public Location (){}

    public Location(String nome, String città){
        this.nome = nome;
        this.città = città;
    }

    public List<Evento> getEvento() {
        return evento;
    }

    public void setEvento(List<Evento> evento) {
        this.evento = evento;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

}
