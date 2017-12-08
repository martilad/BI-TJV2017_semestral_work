/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.semestrworktjvclient;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.ItemsSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.PurchaseSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.ResidenceSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.UsersSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.ItemClient;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.PurchaseClient;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.ResidenceClient;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.UserClient;
import java.util.ArrayList;

/**
 *
 * @author dibik
 */
public class CreateUpdateEntities {
    private final ItemClient itemClient;
    private final UserClient userClient;
    private final ResidenceClient residenceClient;
    private final PurchaseClient purchaseClient;
    private final MyUI mainUI;
    private VerticalLayout layout;
    private Label result = new Label();
    
    private TextField item_id = new TextField("Item ID:");
    private TextField item_name = new TextField("Item name:");
    private TextField item_prize = new TextField("Item prize:");
    private TextField user_id = new TextField("User ID:");
    private TextField user_firstname = new TextField("User first name:");
    private TextField user_surname = new TextField("User surname:");
    private TextField user_personal_id = new TextField("User birth number:");
    private TextField res_id = new TextField("Residence ID:");
    private TextField res_city = new TextField("Residence city");
    private TextField res_street = new TextField("Residence street:");
    private TextField res_street_number = new TextField("Residence street number:");
    private TextField res_zipcode = new TextField("Residence zipcode:");
    private TextField pur_id = new TextField("Purchase ID:");
    private TextField pur_date = new TextField("Purchase date:");
    
    public CreateUpdateEntities(ItemClient itemClient, UserClient userClient, ResidenceClient residenceClient, PurchaseClient purchaseClient, MyUI mainUI) {
        this.itemClient = itemClient;
        this.userClient = userClient;
        this.residenceClient = residenceClient;
        this.purchaseClient = purchaseClient;
        this.mainUI = mainUI;
        layout = new VerticalLayout();
        addComponents();
        
    }

    public VerticalLayout getLayout() {
        return layout;
    }
    
    
    private void addComponents(){
         HorizontalLayout item = new HorizontalLayout();
        item.addComponents(item_id,item_name, item_prize);
        HorizontalLayout user = new HorizontalLayout();
        user.addComponents(user_id, user_firstname, user_surname, user_personal_id);
        HorizontalLayout residence = new HorizontalLayout();
        residence.addComponents(res_id, res_city, res_street, res_street_number, res_zipcode);
        HorizontalLayout purchase = new HorizontalLayout();
        purchase.addComponents(pur_id, pur_date);
        Button insert = new Button("Submit");
        layout.addComponent(item);
        layout.addComponent(user);
        layout.addComponent(residence);
        layout.addComponent(purchase);
        layout.setComponentAlignment(item, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(user, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(residence, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(purchase, Alignment.MIDDLE_CENTER);
        layout.addComponent(insert);
        layout.setComponentAlignment(insert, Alignment.MIDDLE_CENTER);
        layout.addComponent(result);
        layout.setComponentAlignment(result, Alignment.MIDDLE_CENTER);
        result.setStyleName(ValoTheme.LABEL_FAILURE);
        result.setVisible(false);
        insert.addClickListener(e -> {
            result.setStyleName(ValoTheme.LABEL_FAILURE);
            result.setValue("");
            result.setVisible(true);
            ItemsSem itemNewSave = CheckItem();
            if (itemNewSave == null){
                result.setValue("Item Not Save. ");  
            }else{
                result.setStyleName(ValoTheme.LABEL_SUCCESS);
                result.setValue("Item Save. ");
            }
            ResidenceSem residenceNewSave = CheckResidence();
            if (residenceNewSave == null){
                result.setValue(result.getValue() + "Residence Not Save. ");  
            }else{
                result.setStyleName(ValoTheme.LABEL_SUCCESS);
                result.setValue(result.getValue() +"Residence Save. ");
            }
            UsersSem userNewSave = CheckUsers(residenceNewSave);
            if (userNewSave == null){
                result.setValue(result.getValue() + "User Not Save. ");  
            }else{
                result.setStyleName(ValoTheme.LABEL_SUCCESS);
                result.setValue(result.getValue() +"User Save. ");
            }
            PurchaseSem purchaseNewSave = CheckPurchase(userNewSave, itemNewSave);
            if (purchaseNewSave == null){
                result.setValue(result.getValue() + "Purchase Not Save. ");  
            }else{
                result.setStyleName(ValoTheme.LABEL_SUCCESS);
                result.setValue(result.getValue() +"Purchase Save. ");
            }
            
            
            mainUI.RefreshPrint();
        });
    }
    
    
    private ItemsSem CheckItem(){
        String i_id = item_id.getValue();
        String i_name = item_name.getValue();
        String i_prize = item_prize.getValue();
        if (i_id.length() > 0 && RemoveFindEntities.isNumeric(i_id) && i_name.length() == 0 && i_prize.length() == 0){
             ItemsSem test = itemClient.find_JSON(ItemsSem.class, i_id);
             if (test == null){
                 return null;
             }else{
                 return test;
             }
        }else if (i_id.length() > 0 && RemoveFindEntities.isNumeric(i_id) && i_name.length() > 0 && i_prize.length() > 0 ){
            ItemsSem test = itemClient.find_JSON(ItemsSem.class, i_id);
             if (test == null){
                 return null;
             }else{
                 test.setItem_prize(i_prize);
                 test.setItem_name(i_name);
                 itemClient.edit_JSON(test, i_id);
                 return test;
             }
        }else if (i_id.length() == 0 && i_name.length() > 0 && i_prize.length() > 0){
            ItemsSem test = new ItemsSem();
            test.setItem_name(i_name);
            test.setItem_prize(i_prize);
            itemClient.create_JSON(test);
            return test;
        }
        return null;
    }
    
    private ResidenceSem CheckResidence(){
        String r_id = res_id.getValue();
        String r_city = res_city.getValue();;
        String r_street = res_street.getValue();
        String r_s_number = res_street_number.getValue();
        String r_zicode = res_zipcode.getValue();;
        
        if (r_id.length() > 0 && RemoveFindEntities.isNumeric(r_id) && r_city.length() == 0 && r_street.length() == 0 && r_s_number.length() == 0 && r_zicode.length() == 0){
             ResidenceSem test = residenceClient.find_JSON(ResidenceSem.class, r_id);
             if (test == null){
                 return null;
             }else{
                 return test;
             }
        }else if (r_id.length() > 0 && RemoveFindEntities.isNumeric(r_id) && r_city.length() > 0 && r_street.length() > 0 && r_s_number.length() > 0 && r_zicode.length() > 0){
            ResidenceSem test = residenceClient.find_JSON(ResidenceSem.class, r_id);
             if (test == null){
                 return null;
             }else{
                 test.setStreet(r_street);
                 test.setStreet_number(r_s_number);
                 test.setCity(r_city);
                 test.setZip_code(r_zicode);
                 residenceClient.edit_JSON(test, r_id);
                 return test;
             }
        }else if (r_id.length() == 0 && r_city.length() > 0 && r_street.length() > 0 && r_s_number.length() > 0 && r_zicode.length() > 0){
            ResidenceSem test = new ResidenceSem();
            test.setStreet(r_street);
            test.setStreet_number(r_s_number);
            test.setCity(r_city);
            test.setZip_code(r_zicode);
            residenceClient.create_JSON(test);
            return test;
        }
        return null;
      
    }
    private UsersSem CheckUsers(ResidenceSem residence){
        if (residence == null)return null;
        String u_id = user_id.getValue();
        String u_first = user_firstname.getValue();
        String u_sur = user_surname.getValue();
        String u_per = user_personal_id.getValue();
         if (u_id.length() > 0 && RemoveFindEntities.isNumeric(u_id) && u_first.length() == 0 && u_sur.length() == 0 && u_per.length() == 0 ){
             UsersSem test = residenceClient.find_JSON(UsersSem.class, u_id);
             if (test == null){
                 return null;
             }else{
                 return test;
             }
        }else if (u_id.length() > 0 && RemoveFindEntities.isNumeric(u_id) && u_first.length() > 0 && u_sur.length() > 0 && u_per.length() > 0){
            UsersSem test = residenceClient.find_JSON(UsersSem.class, u_id);
             if (test == null){
                 return null;
             }else{
                 test.setFirstname(u_first);
                 test.setSurname(u_sur);
                 test.setPersonal_id_number(u_per);
                 test.setResidence(residence);
                 userClient.edit_JSON(test, u_id);
                 return test;
             }
        }else if (u_id.length() == 0 && u_first.length() > 0 && u_sur.length() > 0 && u_per.length() > 0){
            UsersSem test = new UsersSem();
            test.setFirstname(u_first);
                 test.setSurname(u_sur);
                 test.setPersonal_id_number(u_per);
                 test.setResidence(residence);
            userClient.create_JSON(test);
            return test;
        }
        return null;
    }
    private PurchaseSem CheckPurchase(UsersSem user, ItemsSem item){
        if (user == null || item == null) return null;
        String p_id = pur_id.getValue();
        String p_date = pur_date.getValue();;
        return null;
        
    }
    
    public ItemsSem findItem (String id){
        ItemsSem test = itemClient.find_JSON(ItemsSem.class, id);
        if (test == null){
                return null;
        }
        return test;
    }
    public UsersSem findUser (String id){
        UsersSem test = userClient.find_JSON(UsersSem.class, id);
        if (test == null){
                return null;
        }
        return test;
    }
    public ResidenceSem findResidence (String id){
        ResidenceSem test = residenceClient.find_JSON(ResidenceSem.class, id);
        if (test == null){
                return null;
        }
        return test;
    }
    public PurchaseSem testPurchase (String id){
        PurchaseSem test = purchaseClient.find_JSON(PurchaseSem.class, id);
        if (test == null)
                return null;
        return test;
    }
    
}
