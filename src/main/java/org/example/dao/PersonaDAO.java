package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entites.Partecipazioni;
import org.example.entites.Persona;
import org.example.exceptions.NotFoundException;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona newPersona){
        //1.chiedo di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2. Parte la transazione
        transaction.begin();

        //3. Aggiungo newEvento
        entityManager.persist(newPersona);

        //4.COMMITTOOO TUTTO
        transaction.commit();

        //5.log di salvataggio
        System.out.printf("EVENTO " + newPersona.getNome() + " salvato nel DB");

    }

    public Persona findById(UUID personaId) {
        Persona found = entityManager.find(Persona.class, personaId);
        if(found == null) throw new NotFoundException(personaId);
        return found;
    }

    public void findByIdAndDelete(UUID personaId){
        //1. Cerco il mio evento da cancellare
        Persona found = this.findById(personaId);

        //2. Chiedo di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //3. Faccio partire quindi la transazione
        transaction.begin();

        //4. RIMUOVO dal Persistence l'oggetto
        entityManager.remove(found);

        //5. Per cancellare dal database definitivamente l'evento devo committare la transazione
        transaction.commit();

        //6. Log di avvenuta correttamente cancellazione
        System.out.println("L'evento " + personaId + " è stato eliminato correttamente");
    }
}
