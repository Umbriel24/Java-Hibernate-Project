package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.util.Arrays;


// Sono annotazioni queste. Rappresentano la mappatura
@Entity
@Table(name = "registrati")
public class Registrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indica che l'autoincrementale è compito del database non software
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "sesso")
    private String sesso;

    public Registrato(String name, String surname, String sex) {
        nome = name;
        cognome = surname ;
        sesso = sex ;

    }
    public Registrato() {

    }
    public int getId() {
        return id;
    }

    public void setNome(String nome){
        nome = this.nome;
    }

    public void setCognome(String cognome){
        cognome = this.cognome;
    }

    @Override
    public String toString() {
        return "Persona: " + id + " " + nome + " " + cognome + " " + sesso;
    }
}
