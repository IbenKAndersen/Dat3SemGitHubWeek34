package facade;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CustomerFacade {

    private static CustomerFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CustomerFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /* Exercise 8 */
    public CustomerDTO getCustomerByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            BankCustomer dbcustomer = em.find(BankCustomer.class, id);
            CustomerDTO customer = new CustomerDTO(dbcustomer);
            return customer;
        } finally {
            em.close();
        }
    }

    public List<CustomerDTO> getCustomerByName(String firstName) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<BankCustomer> query = em.createQuery("SELECT c FROM BankCustomer c WHERE c.firstName = :firstname", BankCustomer.class)
                    .setParameter("firstname", firstName);
            List<CustomerDTO> customers = new ArrayList(query.getResultList());
            return customers;
        } finally {
            em.close();
        }
    }

    public BankCustomer addCustomer(BankCustomer cust) {
        EntityManager em = emf.createEntityManager(); //emf comes from the class, it is used through out the program and in tests
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

    public List<BankCustomer> getAllBankCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<BankCustomer> query
                    = em.createQuery("Select c from BankCustomer c", BankCustomer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
