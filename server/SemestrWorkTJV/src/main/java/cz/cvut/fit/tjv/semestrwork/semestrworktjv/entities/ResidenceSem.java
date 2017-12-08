/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dibik
 */
@Entity
@XmlRootElement
public class ResidenceSem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long residence_id;
    private String city;
    private String street;
    private String street_number;

    public Long getResidence_id() {
        return residence_id;
    }

    public void setResidence_id(Long residence_id) {
        this.residence_id = residence_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

   

    

    
    private String zip_code;
   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (residence_id != null ? residence_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResidenceSem)) {
            return false;
        }
        ResidenceSem other = (ResidenceSem) object;
        if ((this.residence_id == null && other.residence_id != null) || (this.residence_id != null && !this.residence_id.equals(other.residence_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.pernamentResidence[ id=" + residence_id + " ]";
    }
    
}
