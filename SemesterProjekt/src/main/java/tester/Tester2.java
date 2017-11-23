/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.User;
import entity.Zip;
import enums.Pets;
import enums.Rented;
import facade.PlaceFacade;
import facade.UserFacade;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Peter Riis
 */
public class Tester2 {
    public static void main(String[] args) throws IOException {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        UserFacade uf = new UserFacade(emf);
        PlaceFacade pf = new PlaceFacade(emf);
        
        Zip zip = new Zip();
        zip.setZipCode(2000);
       
       
        
//pf.createPlace("manden", "manstreet 88", "a manly amount", "3", "grrrrr", Pets.JA, Rented.NEJ, zip);
//        File file = new File("");
//        byte [] picInBytes = new byte[(int) file.length()];
//        uf.createUser("manden", "mandigsen", "user", "1234", "mandligfyr@hotmail.com", "88888888", picInBytes);
//        
        

    pf.editPlace(1, "Dogan Yildirim", "Ishøj", "4", "4", "Pure Royalty", Pets.NEJ, Rented.JA, zip);
        
    }
}
