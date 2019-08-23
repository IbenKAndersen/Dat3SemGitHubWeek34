package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author ibenk
 */
public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() { //private constructor (singleton) gives only one instans
    }

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) { //emf tells which database to use 
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    /* Tested and works */
    public Customer findByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }
    }
    
    /* Tested and works */
    public List<Customer> findByLastName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.lastName = :LASTNAME", Customer.class)
                    .setParameter("LASTNAME", name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /* Tested and works */
    public int getNumberOfCustomers() {
        return instance.allCustomers().size();
    }

    /* Tested and works */
    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery("Select c from Customer c", Customer.class);
            return query.getResultList();
        } finally {
            em.close();

        }
    }

    /* Tested and works */
    public Customer addCustomer(String fName, String lName) {
        Customer customer = new Customer(fName, lName);
        EntityManager em = emf.createEntityManager(); //emf comes from the class, it is used through out the program and in tests
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

}
