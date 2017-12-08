/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.tjv.semestrwork.semestrworktjv.dto;

import cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.PurchaseSem;
import java.util.List;

/**
 *
 * @author dibik
 */
public class PurchaseDTO {
    List<PurchaseSem> purchases;

    public List<PurchaseSem> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseSem> purchases) {
        this.purchases = purchases;
    }
    
    
    
}
