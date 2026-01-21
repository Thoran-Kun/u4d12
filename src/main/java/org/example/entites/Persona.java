package org.example.entites;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column (name = "cognome", nullable = false)
    private String cognome;
    @Column (name = "email", nullable = false)
    private String email;
    @Column (name = "data_di_nascita", nullable = false)
    private LocalDate dataDiNascita;
    @Column (name = "sesso", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sesso sesso;
    //RELAZIONE, una persona può avere più partecipazioni
    @OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
    private List<Partecipazioni> ListaPartecipazioni;

    public Persona(){}

    public Persona(String nome, String cognome,String email, LocalDate dataDiNascita, Sesso sesso){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    public UUID getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazioni> getListaPartecipazioni() {
        return ListaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazioni> listaPartecipazioni) {
        ListaPartecipazioni = listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
                '}';
    }
}
