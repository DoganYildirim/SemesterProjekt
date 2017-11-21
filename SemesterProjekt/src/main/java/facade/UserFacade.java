/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Place;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.User;
import javax.persistence.Query;

/**
 *
 * @author Peter Riis
 */
public class UserFacade{

    public UserFacade(EntityManagerFactory emf){
        this.emf = emf;
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    EntityManagerFactory emfUpdate = Persistence.createEntityManagerFactory("PU");
    EntityManager em = emf.createEntityManager();
    EntityManager emUpdate = emf.createEntityManager();

    public EntityManager getEntityManagerUpdate(){
        return emfUpdate.createEntityManager();
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public void createUser(String name, String lastName, String username, String password, String email, String phoneNo, Place place){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        User user = new User();

        user.setfirstName(name);
        user.setlastName(lastName);
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNo);
        user.setPlace(place);

        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public List<User> getAllUsers(){
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select u from User as u", User.class);
        List<User> user = query.getResultList();
        return user;

    }
}
