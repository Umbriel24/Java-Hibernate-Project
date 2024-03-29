package main;

import DAO.RegistratoDAOimplementato;
import entity.Registrato;

import java.util.List;

public class Main {
    static RegistratoDAOimplementato regiDAO = new RegistratoDAOimplementato();

    Registrato reg01 = new Registrato("Human", "Similaun", "M");
    Registrato reg02 = new Registrato("Jenna", "Perk", "F");

    public static void main(String[] args){
        Read(regiDAO);
    }


    public static void Read(RegistratoDAOimplementato regiDAO){
        List<Registrato> registratoList = regiDAO.read();
        for (Registrato registrato : registratoList) {
            System.out.println(registrato.toString());
        }
    }
}



