/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dibik
 */
@Entity
@XmlRootElement
public class UsersSem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long users_id;
    private String firstname;
    private String surname;
    private String personal_id_number;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESIDENCE_ID")
    private ResidenceSem residence;

    public Long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Long users_id) {
        this.users_id = users_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonal_id_number() {
        return personal_id_number;
    }

    public void setPersonal_id_number(String personal_id_number) {
        this.personal_id_number = personal_id_number;
    }

    public ResidenceSem getResidence() {
        return residence;
    }

    public void setResidence(ResidenceSem residence) {
        this.residence = residence;
    }


  


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (users_id != null ? users_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersSem)) {
            return false;
        }
        UsersSem other = (UsersSem) object;
        if ((this.users_id == null && other.users_id != null) || (this.users_id != null && !this.users_id.equals(other.users_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.users[ id=" + users_id + " ]";
    }
    
}
