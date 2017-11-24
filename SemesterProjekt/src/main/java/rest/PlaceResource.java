/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static entity.Location_.name;
import entity.Place;
import enums.Pets;
import enums.Rented;
import facade.PlaceFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author doganyildirim
 */
@Path("place")
public class PlaceResource
{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PlaceResource
     */
    public PlaceResource()
    {
    }

    /**
     * Retrieves representation of an instance of rest.PlaceResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getAllPlaces")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPlaces()
    {
        PlaceFacade pf = new PlaceFacade(emf);
        List<Place> places = new ArrayList();
        places = pf.getAllPlaces();
        String result = gson.toJson(places);
        return result;
    }

    /**
     * PUT method for updating or creating an instance of PlaceResource
     *
     * @param id
     * @param content representation for the resource
     */
    @PUT
    @Path("\"/{id}\"")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editPlace(@PathParam("id")int id)
    {
        PlaceFacade pf = new PlaceFacade(emf);
        Place p = pf.getPlaceByName("name");
        
        pf.editPlace(
               0, p.getOwner(), p.getAdress(),
                p.getNumberOfRooms(), p.getNumberOfPersons(),
                p.getDescription(), p.getPets(),
                p.getRented(), p.getZip()
        );
    }

    @POST
    @Path("createPlace")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createPlace(String content)
    {
        PlaceFacade pf = new PlaceFacade(emf);
        Place p = gson.fromJson(content, Place.class);

        pf.createPlace(
                p.getOwner(), p.getAdress(),
                p.getNumberOfRooms(), p.getNumberOfPersons(),
                p.getDescription(), p.getPets(),
                p.getRented(), p.getZip()
        );

        return gson.toJson(p);

    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePlace(@PathParam("id") int id)
    {
        PlaceFacade pf = new PlaceFacade(emf);
        pf.deletePlace(id);
    }
}
