/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Admin;
import entity.Place;
import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rune
 */
public class Tester {
    
     public static void main(String[] args) {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    EntityManager em = emf.createEntityManager();
    
    
    em.getTransaction().begin();
    
    User user = new User();
    
    Place place = new Place();
    
    Admin admin = new Admin();
    
    em.persist(user);
   
    
    em.persist(place);
     
    
    em.persist(admin);
    
    em.getTransaction().commit();
    
    em.close();
    
    
    
    
    }
    
   
    
    
}
