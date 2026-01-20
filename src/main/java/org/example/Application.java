package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.entites.Evento;
import org.example.entites.TipoEvento;
import org.example.exceptions.NotFoundException;

public class Application {
private static final EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("u4d12pu");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Questo oggetto gestisce le interazioni col DB dei nuovi eventi che vogliamo creare o eliminare
        EventoDAO ev = new EventoDAO(entityManager);

        //Qui creiamo appunto i nuovi eventi
        Evento party = new Evento("party", "2001-01-01", "party privato", TipoEvento.PRIVATO);
        Evento festaCapodanno = new Evento("Capodanno", "2022-12 -31", "festa di Capodanno", TipoEvento.PUBBLICO);
        Evento 
        //facciamo partire il commit per salvare i nostri eventi
        //----------------------------------- SAVE ------------------------------
        ev.save(party);
        ev.save(festaCapodanno);

        //--------------------------------- FIND BY ID ------------------------------
        try {
            Evento eventoFromDB = ev.findById(1);
            System.out.println(eventoFromDB);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        //------------------------------- FIND BY ID AND DELETE -------------------------
        try{
            ev.findByIdAndDelete(1);
        } catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }



        entityManager.close();
        entityManagerFactory.close();
    }
}
