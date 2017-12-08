/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.tjv.semestrwork.semestrworktjv.dto;

import cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.ResidenceSem;
import java.util.List;

/**
 *
 * @author dibik
 */
public class ResidenceDTO {
    List<ResidenceSem> residence;

    public List<ResidenceSem> getResidence() {
        return residence;
    }

    public void setResidence(List<ResidenceSem> residence) {
        this.residence = residence;
    }
    
}
