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
public class PurchaseSem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchase_id;
    private String date_purchase;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private UsersSem user_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID")
    private ItemsSem item_id;

    public Long getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Long purchase_id) {
        this.purchase_id = purchase_id;
    }

    public String getDate_purchase() {
        return date_purchase;
    }

    public void setDate_purchase(String date_purchase) {
        this.date_purchase = date_purchase;
    }

    public UsersSem getUser_id() {
        return user_id;
    }

    public void setUser_id(UsersSem user_id) {
        this.user_id = user_id;
    }

    public ItemsSem getItem_id() {
        return item_id;
    }

    public void setItem_id(ItemsSem item_id) {
        this.item_id = item_id;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchase_id != null ? purchase_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseSem)) {
            return false;
        }
        PurchaseSem other = (PurchaseSem) object;
        if ((this.purchase_id == null && other.purchase_id != null) || (this.purchase_id != null && !this.purchase_id.equals(other.purchase_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.purchase[ id=" + purchase_id + " ]";
    }
    
}
