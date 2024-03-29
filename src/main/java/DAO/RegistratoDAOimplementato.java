package DAO;

import java.util.*;

import entity.Registrato;
import jdk.jshell.execution.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utility.Utility;


public class RegistratoDAOimplementato implements RegistratoDAO{

    static Utility utility;

    //OGNI SINGOLA OPERAZIONE PREVEDE APERTURA E CHIUSURA SESSIONE.

    //NELLE QUERY SI UTILIZZA IL NOME DELLA ENTITY CLASS NON DEL TAVOLO DEL DATABASE
    @Override
    public List<Registrato> read() {
        Session session = Utility.getSessionFactory().openSession();
        List<Registrato> registrati = session.createQuery("FROM Registrato").list();
        session.close();

        System.out.println("Trovati " + registrati.size() + " registrati");
        return registrati;
    }

    @Override
    public int create(Registrato e) {
        Session session = Utility.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();

        System.out.println("Creazione riuscita di " + e.toString());
        return e.getId();
    }

    @Override
    public void update(Registrato reg) {
        Session session = Utility.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(reg);
        session.getTransaction().commit();
        session.close();

        System.out.println("L'update è stato effettuato con successo: " + reg.toString());
    }

    @Override
    public void delete(int id) {
        Session session = Utility.getSessionFactory().openSession();
        session.beginTransaction();
        Registrato e = findByID(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();

        System.out.println("Registrato cancellato " + e.toString());
    }

    @Override
    public Registrato findByID(int id) {
        Session session = Utility.getSessionFactory().openSession();
        Registrato reg = session.get(Registrato.class, id);
        session.close();
        return reg;
    }

    @Override
    public void deleteAll() {
        Session session = Utility.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Registrato> query = session.createQuery("DELETE FROM Registrato");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Tutti i registrati sono stati cancellati");
    }

    @Override
    public List<Registrato> trovaMaschi() {
        Session session = Utility.getSessionFactory().openSession();
        session.beginTransaction();
        List<Registrato> registrati = session.createQuery("FROM Registrato R WHERE R.sesso = 'M'").list();
        session.getTransaction().commit();
        session.close();

        System.out.println("Tutti i maschi della tabella: ");
        for (Registrato reg: registrati){
            System.out.println(reg.toString());
        }
        return registrati;
    }

}
