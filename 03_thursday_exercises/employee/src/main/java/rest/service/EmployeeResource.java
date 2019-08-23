package rest.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.EmployeeDTO;
import entity.Employee;
import facade.EmployeeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employee")
public class EmployeeResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(emf);
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public EmployeeResource() {
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    /* Exercise 3.1.a.i. tested and works */
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public String all() {
        List<Employee> employees = facade.getAllEmployees();
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee e : employees) {
            employeesDTO.add(new EmployeeDTO(e));
        }
        return gson.toJson(employeesDTO);
    }

    /* Exercise 3.1.a.ii. tested and works */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String id(@PathParam("id") int id) {
        Employee employee = facade.getEmployeeById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        return gson.toJson(employeeDTO);
    }

    /* Exercise 3.1.a.iii. tested and works */
    @GET
    @Path("/highestpaid")
    @Produces({MediaType.APPLICATION_JSON})
    public String highest() {
        List<Employee> employees = facade.getEmployeesWithHighestSalary();
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee e : employees) {
            employeesDTO.add(new EmployeeDTO(e));
        }
        return gson.toJson(employeesDTO);
    }

    /* Exercise 3.1.a.iv. tested and works */
    @GET
    @Path("/name/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public String name(@PathParam("name") String name) {
        List<Employee> employees = facade.getEmployeesByName(name);
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee e : employees) {
            System.out.println(e);
            employeesDTO.add(new EmployeeDTO(e));
        }
        return gson.toJson(employeesDTO);
    }

//    @POST
//    @Consumes({MediaType.APPLICATION_JSON})
//    public void create(Employee entity) {
//        throw new UnsupportedOperationException();
//    }
//
//    @PUT
//    @Path("/{id}")
//    @Consumes({MediaType.APPLICATION_JSON})
//    public void update(Employee entity, @PathParam("id") int id) {
//        throw new UnsupportedOperationException();
//    }
}
