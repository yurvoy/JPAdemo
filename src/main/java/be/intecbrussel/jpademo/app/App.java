package be.intecbrussel.jpademo.app;

import be.intecbrussel.jpademo.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        Person person = new Person();
        person.setFirstName("Jean");
        person.setLastName("Jean");
        person.setAge(40);
        person.setAdress("Roupe plein 16 - 1000 Brussel");
        person.setId(1);

        System.out.println(person);

        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        try {
            emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(person);
            transaction.commit();
            System.out.println("person saved");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
