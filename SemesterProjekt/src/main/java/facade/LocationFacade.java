/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Location;
import entity.Place;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author marcofrydshou1
 */
public class LocationFacade {

    public LocationFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    EntityManagerFactory emfUpdate = Persistence.createEntityManagerFactory("PU");
    EntityManager em = emf.createEntityManager();
    EntityManager emUpdate = emf.createEntityManager();

    public LocationFacade() {
        
    }

    public EntityManager getEntityManagerUpdate() {
        return emfUpdate.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();

    }

    public void createLocation(String description, String name) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Location location = new Location();

            location.setName(name);
            location.setDescription(description);
            em.persist(location);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Location deleteLocation(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Location l = em.find(Location.class, name);
            em.remove(l);
            em.getTransaction().commit();
            return l;
        } finally {
            em.close();
        }
    }

    public Location editLocation(Location location) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Location loc = em.find(Location.class, location.getName());
            if (location != null) {
                loc = location;
                em.merge(loc);
                em.getTransaction().commit();
                return loc;
            }
        } finally {
            em.close();
        }
        return null;
    }

    public Location getLocationByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Location lo = em.find(Location.class, name);
            em.getTransaction().commit();
            return lo;
        } finally {
            em.close();
        }
    }

    public List getAllLocations() {
        try {

            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("Select l from Location as l", Location.class);
            List<Location> location = query.getResultList();
            return location;
        } finally {
            em.close();
        }
    }

}
