Okkey, repository per spiegare Hibernate su JAVA

1. Nel Pom servono due dipendenze: MySQL e Hibernate.

2. Creiamo una DAO nel suo package. La dao è composta da un file Interfaccia e da un file implementazione. La DAO si occupa di compiere le operazioni CRUD

3. Nel package Utility creiamo un factoryBuilder di sessione. Ogni volta che si interagisce col database, apriamo la sessione, facciamo l'azione e
   chiudiamo la sessione.

4. In locale ho uno schema Persone -> Tavolo: registrati con colonne: ID, Nome, Cognome, Sesso e Mail.
   La corrispondenza deve essere creata in entity con il nome della classe AL SINGOLARE

5. Nella cartella Entity, Scriviamo la classe con le giuste mappature @Column, table...

6. In src/main/resources, criamo hibernate.cfg.xml. Sarà il file che permetterà l'accesso al DB.
   In mapping, mettere tutte le classi che sono classi ENTITA', ovvero classi che corrispondono ad un table nel db