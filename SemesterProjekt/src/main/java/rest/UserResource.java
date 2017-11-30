/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.User;
import facade.UserFacade;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
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
 * @author Peter Riis
 */
@Path("user")
public class UserResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of rest.UserResource
     * @return an instance of java.lang.String
     */
    @Path("getUsers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllUsers() {
        
    UserFacade uf = new UserFacade(emf);
    List<User> users = new ArrayList();
    users = uf.getAllUsers();
    String result = gson.toJson(users);
    return result;
    
    }
    
    @Path("getUserByID/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserByID(@PathParam("id") int id) {
        System.out.println(id);    
    UserFacade uf = new UserFacade(emf);
    User user = new User();
    user = uf.getUserByID(id);
    String result = gson.toJson(user);
    return result;
    }
    
    @Path("createUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createUser(String content) throws IOException{
        UserFacade uf = new UserFacade(emf);
        User u = gson.fromJson(content, User.class);
        uf.createUser(
        u.getFirstName(), u.getLastName(),
        u.getUserName(), u.getPassword(), u.getEmail(),
        u.getPhoneNumber(), u.getProfilePic()
        );
        
        return gson.toJson(u);
    }
    
    
    @Path("createUserTest")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createUserTest(String content) throws IOException{
        UserFacade uf = new UserFacade(emf);
        User u = gson.fromJson(content, User.class);
        System.out.println(u.getFirstName());
        uf.createUser(
        u.getFirstName()
        );
        
        return gson.toJson(u);
    }
    
    @Path("deleteUser/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id")int id){
        
        UserFacade uf = new UserFacade(emf);
        uf.deleteUser(id);
    }
    
    
    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     */
    @Path("editUser/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editUser(@PathParam("id")int id) {

        UserFacade uf = new UserFacade(emf);
        User u = uf.getUserByID(id);
        
        uf.editUser(
        0, u.getFirstName(), u.getLastName(),
        u.getUserName(), u.getPassword(), u.getEmail(),
        u.getPhoneNumber(), u.getProfilePic()
        );
    }
}
