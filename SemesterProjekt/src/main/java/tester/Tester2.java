/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.User;
import entity.Zip;
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
       
        User user = new User();
        
        
        File file = new File("");
        byte [] picInBytes = new byte[(int) file.length()];
        uf.createUser("manden", "mandigsen", "user", "1234", "mandligfyr@hotmail.com", "88888888", picInBytes);
        
        
      // uf.createUser("Hans Christian", "Andersen", "user", "1234", "detErGanskeVidst@hotmail.com", "18051805");
//        
//        pf.CreatePlace("Den danske stat","Perkerbakken 5", "4", "200", "Asylansøgere hele banden",Pets.JA, Rented.NEJ,zip );
//        
//         List<Place> places = new ArrayList();
//         places = pf.getAllPlaces();
//        for (int i = 0; i < places.size(); i++) {
//            
//            System.out.println(places.get(i).getAdress());
//            
//        }

//pf.deletePlace(1);
//pf.editPlace(2, "Dogan Yildirim", "Ishøj", "4", "4", "Pure Royalty", Pets.NEJ, Rented.JA, zip);
        
    }
}
