package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.entites.Evento;
import org.example.entites.TipoEvento;

public class Application {
private static final EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("u4d12pu");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EventoDAO ev = new EventoDAO(entityManager);
        Evento party = new Evento("party", "2001-01-01", "party privato", TipoEvento.PRIVATO);

    }
}
