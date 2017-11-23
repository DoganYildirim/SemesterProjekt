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
public class UserPicture implements Serializable {

    @ManyToOne
    private User user;
    
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Blob picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the picture
     */
    public Blob getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(Blob picture) {
        this.picture = picture;
    }

 
    
}
