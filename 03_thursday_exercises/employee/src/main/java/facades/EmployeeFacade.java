package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private EmployeeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    /* Exercise 1.5.a. */
    private Employee getEmployeeById(int id) {
        return null;
    }
    
    /* Exercise 1.5.b. */
    private List<Employee> getEmployeesByName(String name) {
        return null;
    }
    
    /* Exercise 1.5.c. */
    private List<Employee> getAllEmployees() {
        return null;
    }
    
    /* Exercise 1.5.d. */
    private List<Employee> getEmployeesWithHighestSalary(int salary) {
        return null;
    }

    /* Exercise 1.5.e. */
    private Employee createEmployee(String fName, String lName) {
        return null;
    }
    
}
