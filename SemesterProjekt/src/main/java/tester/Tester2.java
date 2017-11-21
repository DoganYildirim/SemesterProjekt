/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.User;
import facade.UserFacade;
import java.util.ArrayList;
import java.util.List;
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
       List<User> listen = new ArrayList();
       listen = uf.getAllUsers();
        System.out.println("mennesker der er så mange " + listen.size());
        
        for (int i = 0; i < listen.size(); i++)
        {
            System.out.println(listen.get(i).getfName());
        }
    }
}
