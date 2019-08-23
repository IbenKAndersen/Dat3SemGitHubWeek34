package facade;

import java.util.List;
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
        facade.addCustomer("Anders","Andersen");
        facade.addCustomer("Bent","Bentsen");
        facade.addCustomer("Carl","Carlsen");
        facade.addCustomer("Carla","Carlsen");

        /* All methods from facade tested and works */
        //System.out.println(facade.findByID(1).toString());
        //System.out.println(facade.findByLastName("Carlsen"));
        //System.out.println(facade.getNumberOfCustomers());
        //System.out.println(facade.allCustomers().toString());
        //System.out.println(facade.allCustomers().size());
        
    }
    
}
