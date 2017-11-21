/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Zip;
import enums.Pets;
import enums.Rented;
import facade.PlaceFacade;
import facade.UserFacade;
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
        PlaceFacade pf = new PlaceFacade(emf);
        
        Zip zip = new Zip();
        zip.setZipCode(2635);
       
        
        uf.createUser("Hans Christian", "Andersen", "user", "1234", "detErGanskeVidst@hotmail.com", "18051805");
        
        pf.CreatePlace("Den danske stat","Perkerbakken 5", "4", "200", "Asylansøgere hele banden",Pets.JA, Rented.NEJ,zip );
        
        
    }
}
