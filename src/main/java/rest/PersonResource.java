package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import facades.FacadeExample;
import facades.PersonFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final PersonFacade FACADE = PersonFacade.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @Path("/all")
    @GET
    @Produces("application/json")
    public String getAllPersons() {
        return GSON.toJson(FACADE.getAllPerson());
    }

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public String getById(@PathParam("id") int id){
        return GSON.toJson(FACADE.getPersonById(id));
    }

    @Path("/delete/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String deletePerson(@PathParam("id") int id) {
        PersonDTO newPersonDTO = FACADE.deletePerson(id);
        return GSON.toJson(newPersonDTO);
    }

    @Path("/addperson")
    @GET
    @Produces("application/json")
    public String addPerson(String person){
        PersonDTO p =GSON.fromJson(person, PersonDTO.class);
        PersonDTO pNew = FACADE.addPerson(p);
        return GSON.toJson((pNew));
    }
}