package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ibenk
 */
public class EntityTested {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try{
            Customer c1 = new Customer("Tony", "Stark");
            Customer c2 = new Customer("Peter", "Parker");
            Customer c3 = new Customer("Pepper", "Potts");
            Customer c4 = new Customer("Steven","Strange");
            em.getTransaction().begin(); //begin transaction
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            em.getTransaction().commit(); //commit transactions
        }finally{
            em.close();
        }
    }
    
}
