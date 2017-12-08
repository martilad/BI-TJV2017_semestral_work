/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.tjv.semestrwork.semestrworktjv.dto;

import cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.ItemsSem;
import java.util.List;

/**
 *
 * @author dibik
 */
public class ItemsDTO {
    List<ItemsSem> items;

    public List<ItemsSem> getItems() {
        return items;
    }

    public void setItems(List<ItemsSem> items) {
        this.items = items;
    }
    
    
}
