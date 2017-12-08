/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.tjv.semestrwork.semestrworktjv.dto;

import cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.UsersSem;
import java.util.List;

/**
 *
 * @author dibik
 */
public class UsersDTO {
    List<UsersSem> users;

    public List<UsersSem> getUsers() {
        return users;
    }

    public void setUsers(List<UsersSem> users) {
        this.users = users;
    }
    
    
    
}
