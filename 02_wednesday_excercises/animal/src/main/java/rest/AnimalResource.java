package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Animal;
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
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service -- this is our web service file
 *
 * @author ibenk
 */
@Path("animal") //class annotation changed to animal
public class AnimalResource {

    @Context
    private UriInfo context;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public AnimalResource() {
    }

    /* Exercise 1 Simple Rest endpoint */
 /* Tested and works on http://localhost:8080/animal/api/animal */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hello from my first web service";
    }

    /* Exercise 2 Json endpoint */
 /* Tested and works on http://localhost:8080/animal/api/animal/random */
    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String randomJson() {
        return "Hello random";
    }

    /* Exercise 3 Return an object */
 /* Tested and works on http://localhost:8080/animal/api/animal/return */
    @GET
    @Path("return")
    @Produces(MediaType.APPLICATION_JSON)
    public String returnJson() {

        List<Animal> animals = new ArrayList<Animal>();
        Animal duck = new Animal("Duck", 2015, "Quack");
        Animal fox = new Animal("Fox", 2004, "Ringdingding");
        Animal seal = new Animal("Seal", 2009, "Ow ow");
        Animal bird = new Animal("Bird", 2017, "Tweet");
        animals.add(duck);
        animals.add(fox);
        animals.add(seal);
        animals.add(bird);
        
        /* Getting a random number and a random animal from this number */
        Random rand = new Random(); 
        int value = rand.nextInt(animals.size()); 
        Animal random = animals.get(value);

        /* Serialize java object to Json */
        String animalAsJson = gson.toJson(random);
        
        return animalAsJson;
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
