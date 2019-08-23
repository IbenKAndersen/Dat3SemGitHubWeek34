package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ibenk
 */
@Path("customer") //class annotation
public class CustomerResource {

    @Context
    private UriInfo context;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public CustomerResource() {
    }

    public List<Customer> createCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        Customer c1 = new Customer("Tony", "Stark");
        Customer c2 = new Customer("Peter", "Parker");
        Customer c3 = new Customer("Pepper", "Potts");
        Customer c4 = new Customer("Steven", "Strange");
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        return customers;
    }

    /* Exercise 4.3.a Show all customers */
 /* Tested and works on http://localhost:8080/customer_web/api/customer/all */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String allCustomersJson() {
        List<Customer> customers = createCustomers();
        String allCustomersAsJson = "";
        for (Customer c : customers) {
            /* Serialize java object to Json */
            String customerAsJson = gson.toJson(c);
            allCustomersAsJson += customerAsJson;
        }
        return allCustomersAsJson;
    }

    /* Exercise 4.3.b Show random customer */
 /* Tested and works on http://localhost:8080/customer_web/api/customer/random */
    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String randomCustomersJson() {
        List<Customer> customers = createCustomers();

        /* Getting a random number and a random customer from this number */
        Random rand = new Random();
        int value = rand.nextInt(customers.size());
        Customer random = customers.get(value);

        /* Serialize java object to Json */
        String customerAsJson = gson.toJson(random);

        return customerAsJson;
    }

    /* Exercise 4.4 Show a specifik customer by id */
 /* Tested and works on http://localhost:8080/customer_web/api/customer/1,2,3,4 */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String customerByIdJson(@PathParam("id") int id) {
        List<Customer> customers = createCustomers();
        int indexToId = -1;
        Customer byId = customers.get(id + indexToId);
        String customerAsJson = gson.toJson(byId);
        return customerAsJson;
    }

    /**
     * PUT method for updating or creating an instance of CustomerResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
