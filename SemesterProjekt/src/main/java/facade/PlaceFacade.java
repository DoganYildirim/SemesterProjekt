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
public class PlaceFacade
{

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

    public void createPlacetwo(String owner, String adress, String numberOfRooms, String numberOfPersons, String description)
    {
        try
        {

            EntityManager em = getEntityManager();
            em.getTransaction().begin();

            Place place = new Place();

            place.setOwner(owner);
            place.setAdress(adress);
            place.setNumberOfRooms(numberOfRooms);
            place.setNumberOfPersons(numberOfPersons);
            place.setDescription(description);

            em.persist(place);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }

    }

    public void createPlace(String owner, String adress, String numberOfRooms, String numberOfPersons, String description, Pets pets, Rented rented, Zip zip)
    {
        try
        {

            EntityManager em = getEntityManager();
            em.getTransaction().begin();

            Place place = new Place();

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
        } finally
        {
            em.close();
        }

    }

    public List getAllPlaces()
    {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("Select p from Place as p", Place.class);
        List<Place> places = query.getResultList();
        return places;

    }

    public Place getPlaceByName(String name)
    {
        EntityManager em = emf.createEntityManager(); 
    
        try
        {
            em.getTransaction().begin();
            Place p = em.find(Place.class, name);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    public void deletePlace(long id)
    {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM  Place p Where p.id = :ID");
        query.setParameter("ID", id).executeUpdate();

        em.getTransaction().commit();
        em.close();
    }

    public void editPlace(long id, String owner, String adress, String numberOfRooms, String numberOfPersons, String description, Pets pets, Rented rented, Zip zip)
    {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Place placeToEdit = em.find(Place.class, id);
        placeToEdit.setOwner(owner);
        placeToEdit.setAdress(adress);
        placeToEdit.setNumberOfRooms(numberOfRooms);
        placeToEdit.setNumberOfPersons(numberOfPersons);
        placeToEdit.setDescription(description);
        placeToEdit.setPets(pets);
        placeToEdit.setRented(rented);
        placeToEdit.setZip(zip);

        em.getTransaction().commit();
        em.close();

    }

}
