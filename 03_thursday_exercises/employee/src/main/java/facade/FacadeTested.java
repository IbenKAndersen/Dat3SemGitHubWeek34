package facade;

import entity.Employee;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ibenk
 */
public class FacadeTested {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(emf);
        facade.createEmployee("Holte Holmen", "Holmen 5", 21000);
        facade.createEmployee("Helma Holmen", "Holmen 5", 21000);
        facade.createEmployee("Gert Gertsen", "Holmen 90", 21000);
        facade.createEmployee("Gerda Gertsen", "Holmen 90", 22000);     

        /* All methods from facade tested and works */
        //System.out.println(facade.getEmployeeById(1));
        //System.out.println(facade.getEmployeesByName("Gert Gertsen"));
        //System.out.println(facade.getAllEmployees());
        //System.out.println(facade.getEmployeesWithHighestSalary());
    }

}
