package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entites.Evento;
import org.example.exceptions.NotFoundException;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento){
        //1.chiedo di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2. Parte la transazione
        transaction.begin();

        //3. Aggiungo newEvento
        entityManager.persist(newEvento);

        //4.COMMITTOOO TUTTO
        transaction.commit();

        //5.log di salvataggio
        System.out.printf("EVENTO " + newEvento.getTitolo() + " salvato nel DB");

    }

    public Evento findById(long eventoId) {
        Evento found = entityManager.find(Evento.class, eventoId);
        if(found == null) throw new NotFoundException(eventoId);
        return found;
    }

    public void findByIdAndDelete(long eventoId){
        //1. Cerco il mio evento da cancellare
        Evento found = this.findById(eventoId);

        //2. Chiedo di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //3. Faccio partire quindi la transazione
        transaction.begin();

        //4. RIMUOVO dal Persistence l'oggetto
        entityManager.remove(found);

        //5. Per cancellare dal database definitivamente l'evento devo committare la transazione
        transaction.commit();

        //6. Log di avvenuta correttamente cancellazione
        System.out.println("L'evento " + eventoId + " è stato eliminato correttamente");
    }
}
