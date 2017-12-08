/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.semestrworktjvclient;

import com.vaadin.ui.Label;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.ItemsDTO;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.ItemsSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.PurchaseDTO;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.PurchaseSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.ResidenceDTO;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.ResidenceSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.UsersDTO;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.UsersSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.ItemClient;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.PurchaseClient;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.ResidenceClient;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.UserClient;

/**
 *
 * @author dibik
 */
public class PrintEntities {
    public static void setItems(Label items, ItemClient client){
        items.setValue("");
        ItemsDTO itemdto = client.findAllItems_JSON(ItemsDTO.class);
            for (ItemsSem item : itemdto.getItems()) {
                items.setValue(items.getValue()+ ItemToString(item) + "\n");
            }
    }
    public static void setUsers(Label users, UserClient client){
        users.setValue("");
        UsersDTO userdto = client.findAllUsers_JSON(UsersDTO.class);
            for (UsersSem object : userdto.getUsers()) {
            users.setValue(users.getValue()+ UserToString(object) + "\n");
        }
    }
    public static void setResidences(Label residences, ResidenceClient client){
        residences.setValue("");
        ResidenceDTO residentdto = client.findAllResidence_JSON(ResidenceDTO.class);
            for (ResidenceSem item : residentdto.getResidence()) {
                residences.setValue(residences.getValue()+ ResidenceToString(item) +  "\n");
            }
    }
    public static void setPurchases(Label purchases, PurchaseClient client){
        purchases.setValue("");
        PurchaseDTO purchasedto = client.findAllPurchases_JSON(PurchaseDTO.class);
            for (PurchaseSem item : purchasedto.getPurchases()) {
                purchases.setValue(purchases.getValue()+ PurchaseToString(item)+ "\n");
            }
    }
    
    public static String ItemToString (ItemsSem item){
        return "ID:" + item.getItem_id() + " Name:" +  item.getItem_name() + " Prize:" + item.getItem_prize();
    }
    public static String UserToString (UsersSem object){
        return "ID:" + object.getUsers_id() + " Name:" + object.getFirstname() + " " + object.getSurname() + " Residence:" + object.getResidence().getResidence_id()+ " Presonal Id:" + object.getPersonal_id_number();
    }
    public static String ResidenceToString (ResidenceSem item){
        return "ID:" + item.getResidence_id() + " City:" +  item.getCity() + " Street:" + item.getStreet() + " Street Number:" + item.getStreet_number()+ " Zip code:" + item.getZip_code();
    }
    public static String PurchaseToString (PurchaseSem item){
        return "ID: " + item.getPurchase_id() +" Date:" + item.getDate_purchase() +  " Item:" +  item.getItem_id().getItem_id() + " User:" + item.getUser_id().getUsers_id();
    }
    
}
