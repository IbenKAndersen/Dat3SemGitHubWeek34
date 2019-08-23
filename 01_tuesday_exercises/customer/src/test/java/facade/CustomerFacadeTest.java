package facade;

import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ibenk
 */
public class CustomerFacadeTest {

    public CustomerFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findByID method, of class CustomerFacade.
     */
    @Test
    public void testFindByID() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade instans = CustomerFacade.getCustomerFacade(emf);
        Customer c1 = new Customer("Pepper","Potts");
        long id = 1;
        Customer expResult = c1;
        Customer result = instans.findByID(id);
        assertEquals(expResult.getFirstName(), result.getFirstName());
    }

    /**
     * Test of findByLastName method, of class CustomerFacade.
     */
    @Test
    public void testFindByLastName() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade instans = CustomerFacade.getCustomerFacade(emf);
        List<Customer> customers = new ArrayList<Customer>();
        Customer c1 = new Customer("Carla","Carlsen");
        customers.add(c1);
        String name = "Carlsen";
        List<Customer> expResult = customers;
        List<Customer> result = instans.findByLastName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfCustomers method, of class CustomerFacade.
     */
    @Test
    public void testGetNumberOfCustomers() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade instans = CustomerFacade.getCustomerFacade(emf);
        int expResult = 4;
        int result = instans.getNumberOfCustomers();
        assertEquals(expResult, result);
    }

    /**
     * Test of allCustomers method, of class CustomerFacade.
     */
    @Test
    public void testAllCustomers() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade instans = CustomerFacade.getCustomerFacade(emf);
        List<Customer> customers = new ArrayList<Customer>();
        List<Customer> expResult = customers;
        List<Customer> result = instans.allCustomers();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCustomer method, of class CustomerFacade.
     */
    @Test
    public void testAddCustomer() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade instans = CustomerFacade.getCustomerFacade(emf);
        String fName = "Thor";
        String lName = "Thorsen";
        Customer expResult = new Customer(fName,lName);
        Customer result = instans.addCustomer(fName, lName);
        assertEquals(expResult, result);
    }

}
