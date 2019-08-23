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
            Employee e1 = new Employee("Holte Holmen", "Holmen 5", 21000);
            Employee e2 = new Employee("Helma Holmen", "Holmen 5", 21000);
            Employee e3 = new Employee("Gert Gertsen", "Holmen 90", 21000);
            Employee e4 = new Employee("Gerda Gertsen", "Holmen 90", 21000);
            em.getTransaction().begin(); //begin transaction
            em.persist(e1);
            em.persist(e2);
            em.persist(e3);
            em.persist(e4);
            em.getTransaction().commit(); //commit transactions
        }finally{
            em.close();
        }
    }
    
}
