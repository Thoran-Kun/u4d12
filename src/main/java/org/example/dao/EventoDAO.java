package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entites.Evento;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento){
        //
        EntityTransaction transaction = entityManager.getTransaction();
    }
}
