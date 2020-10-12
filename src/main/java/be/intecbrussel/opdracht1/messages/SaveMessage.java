package be.intecbrussel.opdracht1.messages;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMessage {
    public static void main(String[] args) {

        Message message = new Message();
        message.setMessage("Hello Bart");
        message.setId(1);

        EntityManagerFactory emf = null;
        EntityManager em = null;


        try {
            emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(message);
            System.out.println("message saved");
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
