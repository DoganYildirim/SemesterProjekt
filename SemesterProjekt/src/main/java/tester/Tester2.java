/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import facade.UserFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Peter Riis
 */
public class Tester2 {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        UserFacade uf = new UserFacade(emf);
        
        uf.createUser("Hans Christian", "Andersen", "user", "1234", "detErGanskeVidst@hotmail.com", "18051805");
        
        
    }
}
