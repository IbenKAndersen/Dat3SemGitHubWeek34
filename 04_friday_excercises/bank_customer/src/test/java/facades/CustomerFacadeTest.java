package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ibenk
 */
public class CustomerFacadeTest {

    public CustomerFacadeTest() {
    }

    @BeforeClass //kører en gang før hver test
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before //kører før hver eneste metoder
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFacadeExample method, of class CustomerFacade.
     */
//    @Test
//    public void testGetFacadeExample() {
//        System.out.println("getFacadeExample");
//        EntityManagerFactory _emf = null;
//        CustomerFacade expResult = null;
//        CustomerFacade result = CustomerFacade.getFacadeExample(_emf);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getCustomerByID method, of class CustomerFacade.
//     */
//    @Test
//    public void testGetCustomerByID() {
//        System.out.println("getCustomerByID");
//        int id = 0;
//        CustomerFacade instance = null;
//        CustomerDTO expResult = null;
//        CustomerDTO result = instance.getCustomerByID(id);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getCustomerByName method, of class CustomerFacade.
//     */
//    @Test
//    public void testGetCustomerByName() {
//        System.out.println("getCustomerByName");
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
//        String firstName = "Jens";
//        List<CustomerDTO> expResult = null;
//        List<CustomerDTO> result = facade.getCustomerByName(firstName);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of addCustomer method, of class CustomerFacade.
//     */
//    @Test
//    public void testAddCustomer() {
//        System.out.println("addCustomer");
//        BankCustomer cust = null;
//        CustomerFacade instance = null;
//        BankCustomer expResult = null;
//        BankCustomer result = instance.addCustomer(cust);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getAllBankCustomers method, of class CustomerFacade.
//     */
//    @Test
//    public void testGetAllBankCustomers() {
//        System.out.println("getAllBankCustomers");
//        CustomerFacade instance = null;
//        List<BankCustomer> expResult = null;
//        List<BankCustomer> result = instance.getAllBankCustomers();
//        assertEquals(expResult, result);
//    }

}
