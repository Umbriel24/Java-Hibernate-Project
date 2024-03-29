package main;

import DAO.RegistratoDAO;
import DAO.RegistratoDAOimplementato;
import entity.Registrato;
import org.hibernate.annotations.Cascade;

import java.lang.constant.Constable;
import java.util.List;
import java.util.Scanner;

public class Main {
    static RegistratoDAOimplementato regiDAO = new RegistratoDAOimplementato();

    Registrato reg01 = new Registrato("Human", "Similaun", "M");
    Registrato reg02 = new Registrato("Jenna", "Perk", "F");

    public static void main(String[] args){

        System.out.println("Ciao utente, scegliere operazione: ");
        System.out.println("0, Create");
        System.out.println("1, Read");
        System.out.println("2, Update");
        System.out.println("3, Delete");
        System.out.println("-----Extra------");
        System.out.println("4, Find by Id");
        System.out.println("5, Delete All");
        System.out.println("6, Trova Maschi");
        System.out.println("7, Esci");

        boolean esci = false;
        while(!esci) {
            System.out.println("Inserisci il numero dell'azione da compiere: ");
            int number = new Scanner(System.in).nextInt();
            switch (number) {
                case 0:
                    Create(regiDAO);
                    break;
                case 1:
                    Read(regiDAO);
                    break;
                case 2:
                    Update(regiDAO);
                    break;
                case 3:
                    Delete(regiDAO);
                    break;
                case 4:
                    FindById(regiDAO);
                    break;
                case 5:
                    DeleteAll(regiDAO);
                    break;
                case 6:
                    TrovaMaschi(regiDAO);
                    break;
                default:
                    esci = true;
                    return;
            }
        }




    }


    public static void Read(RegistratoDAOimplementato regiDAO){
        List<Registrato> registratoList = regiDAO.read();
        for (Registrato registrato : registratoList) {
            System.out.println(registrato.toString());
        }
    }

    public static void Create(RegistratoDAOimplementato regiDAO){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserire dati del nuovo utente registrato");
        System.out.print("Nome: ");
        String NomeTemp = scanner.next();
        System.out.println("\nCognome: ");
        String cognomeTemp = scanner.next();
        System.out.println("\nSesso: ");
        String sessoTemp = scanner.next();

        Registrato registratoNew = new Registrato(NomeTemp, cognomeTemp, sessoTemp);
        regiDAO.create(registratoNew);
    }

    public static void Update(RegistratoDAOimplementato regiDAO){
        System.out.println("Inserisci l'ID di chi vuoi modificare: ");
        int idTemp = new Scanner(System.in).nextInt();

        Registrato regTemp = regiDAO.findByID(idTemp);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Scrivi il suo nome: ");
        String nomeTemp = scanner.next();

        System.out.println("Scrivi il suo Cognome: ");
        String cognomeTemp = scanner.next();

        regTemp.setNome(nomeTemp);
        regTemp.setCognome(cognomeTemp);
        System.out.println("La nuova persona sarà: " + regTemp.toString());

        regiDAO.update(regTemp);
    }

    public static void Delete(RegistratoDAOimplementato regiDAO){
        System.out.println("Inserisci l'ID che vuoi eliminare");
        int id = new Scanner(System.in).nextInt();

        regiDAO.delete(id);
    }

    public static void FindById(RegistratoDAOimplementato regiDAO){
        System.out.println("Inserisci l'ID della persona che vuoi cercare:");
        int id = new Scanner(System.in).nextInt();

        Registrato regTemp = regiDAO.findByID(id);
        System.out.println("Ecco la persona: " + regTemp.toString());
    }

    public static void DeleteAll(RegistratoDAOimplementato regiDAO){
        System.out.println("Sei sicuro di volerlo fare? S/N");
        String  lettera = new Scanner(System.in).next();
        if (lettera.charAt(0) == 'S'){
            System.out.println("Scrivi il numero 99");
            int numTemp = new Scanner(System.in).nextInt();

            if(numTemp == 99){
                regiDAO.deleteAll();
            } else {
                System.out.println("Ritorno al menu");
                return;
            }
        }
        else {
            System.out.println("Ritorno al menu");
            return;
        }
    }


    public static void TrovaMaschi(RegistratoDAOimplementato regiDAO){
        regiDAO.trovaMaschi();
    }
}



