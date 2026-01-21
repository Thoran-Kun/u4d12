package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entites.Location;
import org.example.entites.Partecipazioni;
import org.example.exceptions.NotFoundException;

import java.util.UUID;

public class PartecipazioniDAO {
    private final EntityManager entityManager;

    public PartecipazioniDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazioni newPartecipazioni){
        //1.chiedo di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2. Parte la transazione
        transaction.begin();

        //3. Aggiungo newEvento
        entityManager.persist(newPartecipazioni);

        //4.COMMITTOOO TUTTO
        transaction.commit();

        //5.log di salvataggio
        System.out.printf("EVENTO " + newPartecipazioni.getEvento() + " salvato nel DB");

    }

    public Partecipazioni findById(UUID partecipazioniId) {
        Partecipazioni found = entityManager.find(Partecipazioni.class, partecipazioniId);
        if(found == null) throw new NotFoundException(partecipazioniId);
        return found;
    }

    public void findByIdAndDelete(UUID partecipazioniId){
        //1. Cerco il mio evento da cancellare
        Partecipazioni found = this.findById(partecipazioniId);

        //2. Chiedo di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //3. Faccio partire quindi la transazione
        transaction.begin();

        //4. RIMUOVO dal Persistence l'oggetto
        entityManager.remove(found);

        //5. Per cancellare dal database definitivamente l'evento devo committare la transazione
        transaction.commit();

        //6. Log di avvenuta correttamente cancellazione
        System.out.println("L'evento " + partecipazioniId + " è stato eliminato correttamente");
    }
}
