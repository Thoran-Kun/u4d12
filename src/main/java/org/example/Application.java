package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventoDAO;
import org.example.dao.LocationDAO;
import org.example.dao.PartecipazioniDAO;
import org.example.dao.PersonaDAO;
import org.example.entites.*;
import org.example.exceptions.NotFoundException;

import java.time.LocalDate;

public class Application {
private static final EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("u4d12pu");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Questo oggetto gestisce le interazioni col DB dei nuovi eventi che vogliamo creare o eliminare
        EventoDAO ev = new EventoDAO(entityManager);
        LocationDAO ld = new LocationDAO(entityManager);
        PartecipazioniDAO partd = new PartecipazioniDAO(entityManager);
        PersonaDAO pd = new PersonaDAO(entityManager);
        //Qui creiamo appunto i nuovi eventi
        //Evento party = new Evento("party", LocalDate.of(2001,1,1), "party privato", TipoEvento.PRIVATO, 10);
        //Evento festaCapodanno = new Evento("Capodanno", LocalDate.of(2022,12 ,31), "festa di Capodanno", TipoEvento.PUBBLICO, 100);
        //Evento compleanno = new Evento("Compleanno", LocalDate.of(2020,1,3), "Festa Compleanno a sorpresa", TipoEvento.PRIVATO, 30);
        //facciamo partire il commit per salvare i nostri eventi
        //----------------------------------- SAVE ------------------------------
        //ev.save(party);
        //ev.save(festaCapodanno);
        //ev.save(compleanno);

        //creo la location nuova
        Location milano = new Location("San Siro", "Milano");
        ld.save(milano);

        //creo una nuova Persona
        Persona user = new Persona("Salvatore", "Pepe", "miamail@ciao", LocalDate.of(1991,01,03), Sesso.MASCHIO);
        pd.save(user);
        //Evento concert = new Evento("Rock", LocalDate.now().plusMonths(2), "Amazing", TipoEvento.PUBBLICO, 500000);
        //creato il concerto setto la location tramite i set
        //concert.setLocation(milano);
        //una volta creato tutto risalvo l'evento
        //ev.save(concert);
        //dopodichè setto la partecipazione
        //Partecipazioni partecipazione = new Partecipazioni(user, concert, StatoPartecipazione.CONFERMATO);
       //ogni volta che creo qualcosa la devo sempre salvare
        //partd.save(partecipazione);

        //--------------------------------- FIND BY ID ------------------------------
//        try {
//            Evento eventoFromDB = ev.findById(concert.getId());
//            System.out.println(eventoFromDB);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

        //------------------------------- FIND BY ID AND DELETE -------------------------
//        try{
//            ev.findByIdAndDelete(1);
//        } catch (NotFoundException ex){
//            System.out.println(ex.getMessage());
//        }



        entityManager.close();
        entityManagerFactory.close();
    }
}
