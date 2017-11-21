/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Place;
import entity.Zip;
import enums.Pets;
import enums.Rented;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Peter Riis
 */
public class PlaceFacade {

     public PlaceFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    EntityManagerFactory emfUpdate = Persistence.createEntityManagerFactory("PU");
    EntityManager em = emf.createEntityManager();
    EntityManager emUpdate = emf.createEntityManager();

    public EntityManager getEntityManagerUpdate()
    {
        return emfUpdate.createEntityManager();
    }

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }
    
    public void CreatePlace(String owner, String adress, String numberOfRooms, String numberOfPersons, String description, Pets pets, Rented rented, Zip zip){
        
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        
        Place place= new Place();
        
        place.setOwner(owner);
        place.setAdress(adress);
        place.setNumberOfRooms(numberOfRooms);
        place.setNumberOfPersons(numberOfPersons);
        place.setDescription(description);
        place.setPets(pets);
        place.setRented(rented);
        place.setZip(zip);
        
        em.persist(place);
        em.getTransaction().commit();
        em.close();

    }
    
    public List getAllPlaces(){
        
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Place as p", Place.class);
        List <Place> places = query.getResultList();
        return places;
        
        
        
    }
    
}
