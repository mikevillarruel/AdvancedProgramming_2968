/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
@Path("channelCapacity")
public class ChannelCapacity {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CapacidadCanal
     */
    public ChannelCapacity() {
    }

    /**
     * Retrieves representation of an instance of datos.CapacidadCanal
     * @return an instance of java.lang.String
     */
    @Path("{bandwidth}/{signalPower}/{noisePower}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    
    public String getChannelCapacity(@PathParam("bandwidth") double bandwidth, @PathParam("signalPower") double signalPower, @PathParam("noisePower") double noisePower ) {
        
        double channelCapacity = bandwidth * (Math.log(1+signalPower/noisePower)/Math.log(2));
        
        return "La capacidad del canal es de: "+channelCapacity+" bit/s";
    
    }


    /**
     * PUT method for updating or creating an instance of CapacidadCanal
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
