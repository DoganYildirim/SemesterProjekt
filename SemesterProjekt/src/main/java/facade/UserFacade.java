/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public void createUser(String name, String lastName, String username, String password, String email, String phoneNo, byte[] picInBytes) throws FileNotFoundException, IOException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        User user = new User();

        user.setFirstName(name);
        user.setLastName(lastName);
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNo);

        File file = new File("C:\\Users\\Peter Riis\\Desktop\\maymays\\Doggos\\hqdefault.jpg");
        picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(picInBytes);
        fileInputStream.close();
        user.setProfilePic(picInBytes);

        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
    
    public User userLogin(String username, String password){
       
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            User user = new User(username, password);
            em.persist(user);
            em.getTransaction().commit();
            return user;
            
        }catch (Exception e){
            return null;
            
        }finally{
            em.close();
        }
                
    }

    public List<User> getAllUsers(){
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select u from User as u", User.class);
        List<User> user = query.getResultList();
        return user;

    }
    
    public User deleteuser(String username){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            User u = em.find(User.class, username);
            em.remove(u);
            em.getTransaction().commit();
            return u;    
        }finally{
            em.close();
        }
                  
    }
    
   public User edituser(User user){
       EntityManager em = emf.createEntityManager();
       try{
           em.getTransaction().begin();
           User u = em.find(User.class, user.getUserName());
           if(user !=null){
               u = user;
               em.merge(u);
               em.getTransaction().commit();
               return u;
           }
                   }finally{
           em.close();
                            
       }
       return null;
       
   }
   
   
   public User getUserByID(long id){
       EntityManager em = emf.createEntityManager();
       try{
           em.getTransaction().begin();
           User us = em.find(User.class, id);
           em.getTransaction().commit();
           return us;
           
       }finally{
           em.close();
       }
       
       
   }
   
    
    
    
    
}
