package org.example.entites;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Persona {
    @OneToMany(mappedBy = "evento")
    List<Partecipazione> partecipazioni = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


}
