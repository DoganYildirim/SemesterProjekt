/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.Pets;
import enums.Rented;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Rune
 */
@Entity
public class Place implements Serializable {

 
    
   

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String owner;
    private String adress;
    private String numberOfRooms;
    private String numberOfPersons;
    private String description;
    private Pets pets;
    private Rented rented;

    public Place() {
    }

    public Place(String owner, String adress, String numberOfRooms, String numberOfPersons, String description, Pets pets, Rented rented, Zip zip) {
        this.owner = owner;
        this.adress = adress;
        this.numberOfRooms = numberOfRooms;
        this.numberOfPersons = numberOfPersons;
        this.description = description;
        this.pets = pets;
        this.rented = rented;
        this.zip = zip;
    }

    
    public Place(String owner, String adress, String numberOfRooms, String numberOfPersons) {
        this.owner = owner;
        this.adress = adress;
        this.numberOfRooms = numberOfRooms;
        this.numberOfPersons = numberOfPersons;
    }
    
    
    
    
    
    
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Zip zip;
    
    @OneToMany(mappedBy = "place")
    List<User> users = new ArrayList();
    
    @OneToMany(mappedBy = "place")
    List <PlacePicture> placePicture = new ArrayList();
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

 
    /**
     * @return the numberOfRooms
     */
    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * @param numberOfRooms the numberOfRooms to set
     */
    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    /**
     * @return the numberOfPersons
     */
    public String getNumberOfPersons() {
        return numberOfPersons;
    }

    /**
     * @param numberOfPersons the numberOfPersons to set
     */
    public void setNumberOfPersons(String numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the pets
     */
    public Pets getPets() {
        return pets;
    }

    /**
     * @param pets the pets to set
     */
    public void setPets(Pets pets) {
        this.pets = pets;
    }

    /**
     * @return the rented
     */
    public Rented getRented() {
        return rented;
    }

    /**
     * @param rented the rented to set
     */
    public void setRented(Rented rented) {
        this.rented = rented;
    }

       /**
     * @return the zip
     */
    public Zip getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(Zip zip) {
        this.zip = zip;
    }

    
}
