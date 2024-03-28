package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;


// Sono annotazioni queste. Rappresentano la mappatura
@Entity
@Table(name = "registrati")
public class Registrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indica che l'autoincrementale è compito del database non software
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private char[] nome;

    @Column(name = "cognome")
    private char[] cognome;

    @Column(name = "sesso")
    private char[] sesso;

}
