package utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Utility {
    //E' un design pattern builder, costruisce gli oggetti attributo per attributo.
    public static SessionFactory getSessionFactory(){
        //ServiceRegistry, fornisce le credenziali ad un software quando deve accedergli
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sFactory = metadata.getSessionFactoryBuilder().build();
        return sFactory;
    }
}
