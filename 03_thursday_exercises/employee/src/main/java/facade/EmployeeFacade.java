package facade;

import entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private EmployeeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
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
    public Employee getEmployeeById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Employee employee = em.find(Employee.class, id);
            return employee;
        } finally {
            em.close();
        }
    }

    /* Exercise 1.5.b. */
    public List<Employee> getEmployeesByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.name = :name", Employee.class)
                    .setParameter("name", name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /* Exercise 1.5.c. */
    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("Select e from Employee e", Employee.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /* Exercise 1.5.d. */
    public List<Employee> getEmployeesWithHighestSalary(int salary) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(z.salary) FROM Employee z)", Employee.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /* Exercise 1.5.e. */
    public Employee createEmployee(String name, String address, int salary) {
        Employee employee = new Employee(name, address, salary);
        EntityManager em = emf.createEntityManager(); 
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } finally {
            em.close();
        }
    }

}
