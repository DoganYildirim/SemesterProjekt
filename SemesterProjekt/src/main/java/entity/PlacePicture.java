/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Rune
 */
@Entity
public class PlacePicture implements Serializable {

    @ManyToOne
    private Place place;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Blob placePicture;

   
    
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
    

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the placePicture
     */
    public Blob getPlacePicture() {
        return placePicture;
    }

    /**
     * @param placePicture the placePicture to set
     */
    public void setPlacePicture(Blob placePicture) {
        this.placePicture = placePicture;
    }

   
    
}
