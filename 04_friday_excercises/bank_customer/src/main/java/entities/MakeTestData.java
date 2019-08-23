package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ibenk
 */
public class MakeTestData {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
        BankCustomer bc1 = new BankCustomer("Jenni", "Jensen", "100-1234", 10092.0, 1, "New customer");
        BankCustomer bc2 = new BankCustomer("Janne", "Jansen", "100-7362", 6857.0, 1, "Top");
        BankCustomer bc3 = new BankCustomer("Jens", "Jensen", "100-8271", 983.0, 2, "");
        BankCustomer bc4 = new BankCustomer("Jørgen", "Jørgensen", "100-8251", 15.0, 4, "");
            em.getTransaction().begin(); //begin transaction
            em.persist(bc1);
            em.persist(bc2);
            em.persist(bc3);
            em.persist(bc4);
            em.getTransaction().commit(); //commit transactions
        } finally {
            em.close();
        }
    }

}
