package facade;

import entities.BankCustomer;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ibenk
 */
public class FacadeTested {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf); //how to get the singleton instance of facade
        BankCustomer bc1 = new BankCustomer("Jenni", "Jensen", "100-1234", 10092.0, 1, "New customer");
        BankCustomer bc2 = new BankCustomer("Janne", "Jansen", "100-7362", 6857.0, 1, "Top");
        BankCustomer bc3 = new BankCustomer("Jens", "Jensen", "100-8271", 983.0, 2, "");
        BankCustomer bc4 = new BankCustomer("Jørgen", "Jørgensen", "100-8251", 15.0, 4, "");
        facade.addCustomer(bc1);
        facade.addCustomer(bc2);
        facade.addCustomer(bc3);
        facade.addCustomer(bc4);

        /* Testing the metohods from CustomerFacade, jUnit test not made yet */
        //System.out.println(facade.getAllBankCustomers());
        //System.out.println(facade.getCustomerByID(1));
        //System.out.println(facade.getCustomerByName("Jens"));
    }

}
