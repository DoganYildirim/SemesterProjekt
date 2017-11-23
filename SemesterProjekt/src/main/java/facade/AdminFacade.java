/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Admin;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marcofrydshou1
 */
public class AdminFacade {
    
    public AdminFacade(EntityManagerFactory emf)
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
    
    
    
    public Admin getAdminByID(Long id){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Admin admin = em.find(Admin.class, id);
            em.getTransaction().commit();
            return admin;
        }finally{
            em.close();
        }         
    }
    
    
    public Admin createAdmin(Admin admin){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(admin);
            em.getTransaction().begin();
            
        }finally{
            em.close();
        }
        return admin;
                
    }
    
    
    public Admin deleteAdmin(String username){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Admin admin = em.find(Admin.class, username);
            em.remove(admin);
            em.getTransaction().commit();
            return admin;  
        }finally{
            em.close();
        }   
    }
    
    
    public Admin editAdmin(Admin admin){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Admin a = em.find(Admin.class, admin.getId());
            if(a !=null){
                a = admin;
                em.merge(a);
                em.getTransaction().commit();
            }
            
        }finally{
            em.close();
        }
        return null;
    }
    
}
