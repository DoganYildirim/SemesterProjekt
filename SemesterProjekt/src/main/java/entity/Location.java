/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.LocationCategori;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author marcofrydshou1
 */
@Entity
public class Location implements Serializable {
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String description;
    private String name;
    private LocationCategori locationcategori;
    
  //  @OneToMany(mappedBy= "location")
   // List<User> users = new ArrayList<>();
    
   // @OneToMany(mappedBy= "location")
   // List<LocationPicture> locationpicture = new ArrayList<>();
    
    

    
    
    
    public LocationCategori getLocationcategori() {
        return locationcategori;
    }

    public void setLocationcaterogi(LocationCategori locationcategori) {
        this.locationcategori = locationcategori;
    }
    

    
    public Location() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    
}
