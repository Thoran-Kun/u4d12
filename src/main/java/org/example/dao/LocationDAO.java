package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entites.Evento;
import org.example.entites.Location;
import org.example.exceptions.NotFoundException;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location newLocation){
        //1.chiedo di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //2. Parte la transazione
        transaction.begin();

        //3. Aggiungo newEvento
        entityManager.persist(newLocation);

        //4.COMMITTOOO TUTTO
        transaction.commit();

        //5.log di salvataggio
        System.out.printf("EVENTO " + newLocation.getEvento() + " salvato nel DB");

    }

    public Location findById(long locationId) {
        Location found = entityManager.find(Location.class, locationId);
        if(found == null) throw new NotFoundException(locationId);
        return found;
    }

    public void findByIdAndDelete(long locationId){
        //1. Cerco il mio evento da cancellare
        Location found = this.findById(locationId);

        //2. Chiedo di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        //3. Faccio partire quindi la transazione
        transaction.begin();

        //4. RIMUOVO dal Persistence l'oggetto
        entityManager.remove(found);

        //5. Per cancellare dal database definitivamente l'evento devo committare la transazione
        transaction.commit();

        //6. Log di avvenuta correttamente cancellazione
        System.out.println("L'evento " + locationId + " è stato eliminato correttamente");
    }
}
