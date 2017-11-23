/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Zip;
import enums.Pets;
import enums.Rented;
import facade.LocationFacade;
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
        LocationFacade fa = new LocationFacade();
        
       fa.createLocation("Christiansborg", "Dansk historie");
        fa.createLocation("Dansk Dansk", "Kanalrundfart");
       // fa.deleteLocation("Kanalrundfart");
        
        
        
        Zip zip = new Zip();
        zip.setZipCode(2000);
       
        
       uf.createUser("Hans Christian", "Andersen", "user", "1234", "detErGanskeVidst@hotmail.com", "18051805");
       uf.createUser("Børge", "jens", "userjens", "999", "detErGanskeVidst@hotmail.com", "18051805");
       uf.createUser("Adam", "Adnersen", "useradam", "000", "detErGanskeVidst@hotmail.com", "18051805");
       
      // uf.deleteuser(1);
       
       //pf.CreatePlace("marco", "ishøj", "12", "12", "det vildeste", Pets.JA, Rented.NEJ, zip);
       pf.CreatePlacetwo("jens", "hallo", "23","45", "meget flot");
       uf.getUserByID(1);
       
       
        System.out.println(uf.getAllUsers().toString());
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
