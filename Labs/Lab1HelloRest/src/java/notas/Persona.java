/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notas;

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
 * @author Mike
 */
@Path("persona")
public class Persona {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Persona
     */
    public Persona() {
    }

    /**
     * Retrieves representation of an instance of notas.Persona
     * @return an instance of java.lang.String
     */
    @Path("lastName")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPersonData() {
        //TODO return proper representation object
        return "Villarruel";
        //throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Persona
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
    
    @Path("{lastName}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGrades(@PathParam("lastName") String lastName) {
        if (lastName.equals("Lascano")){
            return "10";
        }else if(lastName.equals("Villarruel")){
            return "20";
        }else{
            return "No exite el usuario";
        }
    }
    
    
    
    
}
