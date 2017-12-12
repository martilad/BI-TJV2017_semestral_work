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
import com.vaadin.ui.RadioButtonGroup;
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

/**
 *
 * @author dibik
 */
public class RemoveFindEntities {
    private final ItemClient itemClient;
    private final UserClient userClient;
    private final ResidenceClient residenceClient;
    private final PurchaseClient purchaseClient;
    private final MyUI mainUI;
    private VerticalLayout layout;
    private TextField inputID = new TextField("ID:");
    private RadioButtonGroup<String> radio = new RadioButtonGroup<>("Select:");
    private Label result = new Label();

    public RemoveFindEntities(ItemClient itemClient, UserClient userClient, ResidenceClient residenceClient, PurchaseClient purchaseClient, MyUI mainUI) {
        this.itemClient = itemClient;
        this.userClient = userClient;
        this.residenceClient = residenceClient;
        this.purchaseClient = purchaseClient;
        this.mainUI = mainUI;
        layout = new VerticalLayout();
        Button remove = new Button("Remove");
        Button find = new Button("Find");
        radio.setItems("Items", "Users", "Residence", "Purchase");
        HorizontalLayout hori = new HorizontalLayout();
        hori.addComponent(inputID);
        hori.addComponent(radio);
        hori.addComponent(remove);
        hori.addComponent(find);
        hori.setComponentAlignment(inputID, Alignment.MIDDLE_CENTER);
        hori.setComponentAlignment(radio, Alignment.MIDDLE_CENTER);
        hori.setComponentAlignment(remove, Alignment.MIDDLE_CENTER);
        hori.setComponentAlignment(find, Alignment.MIDDLE_CENTER);
        layout.addComponent(hori);
        layout.setComponentAlignment(hori, Alignment.MIDDLE_CENTER);
        layout.addComponent(result);
        layout.setComponentAlignment(result, Alignment.MIDDLE_CENTER);
        result.setStyleName(ValoTheme.LABEL_FAILURE);
        result.setVisible(false);
        remove.addClickListener(e -> {
            result.setVisible(true);
            String select = radio.getValue();
            if (select == null){
                result.setValue("Select entity.");
                return;
            }
            String insert = inputID.getValue();
            if (insert.length()==0){
                result.setValue("Type ID.");
                return;
            }
            switch (select) {
                case "Items":
                    result.setValue(removeItem(insert));
                    break;
                case "Users":
                    result.setValue(removeUser(insert));
                    break;
                case "Residence":
                    result.setValue(removeResidence(insert));
                    break;
                case "Purchase":
                    result.setValue(removePurchase(insert));
                    break;
            }
            mainUI.RefreshPrint();
        });
        find.addClickListener(e -> {
            result.setVisible(true);
            String select = radio.getValue();
            if (select == null){
                result.setValue("Select entity.");
                return;
            }
            String insert = inputID.getValue();
            if (insert.length()==0){
                result.setValue("Type ID.");
                return;
            }
            switch (select) {
                case "Items":
                    result.setValue(findItemToString(insert));
                    break;
                case "Users":
                    result.setValue(findUserToString(insert));
                    break;
                case "Residence":
                    result.setValue(findResidenceToString(insert));
                    break;
                case "Purchase":
                    result.setValue(findPurchaseToString(insert));
                    break;
            }
            mainUI.RefreshPrint();
        });
    }

    public VerticalLayout getLayout() {
        return layout;
    }
    
    private String removeItem(String id){
        ItemsSem test = testItem(id);
        if (test == null){
            return "Item not exists.";
        }
        itemClient.remove(id);
        result.setStyleName(ValoTheme.LABEL_SUCCESS);
        return "Item " + id + " remove.";
    }
    private String removeUser(String id){
        UsersSem test = testUser(id);
        if (test == null){
            return "User not exists.";
        }
        userClient.remove(id);
        result.setStyleName(ValoTheme.LABEL_SUCCESS);
        return "User " + id + " remove.";
    }
    private String removeResidence(String id){
        ResidenceSem test = testResidence(id);
        if (test == null){
            return "Residence not exists.";
        }
        residenceClient.remove(id);
        result.setStyleName(ValoTheme.LABEL_SUCCESS);
        return "Residences " + id + " remove.";
    }
    private String removePurchase(String id){
       PurchaseSem test = testPurchase(id);
        if (test == null){
            return "Purchase not exists.";
        }
        purchaseClient.remove(id);
        result.setStyleName(ValoTheme.LABEL_SUCCESS);
        return "Purchase " + id + " remove.";
    }
    private String findItemToString(String id){
        ItemsSem test = testItem(id);
        if (test == null){
            return "Item not exists.";
        }
        result.setStyleName(ValoTheme.LABEL_SUCCESS);
        return PrintEntities.ItemToString(test);
    }
    private String findUserToString(String id){
        UsersSem test = testUser(id);
        if (test == null){
            return "User not exists.";
        }
        result.setStyleName(ValoTheme.LABEL_SUCCESS);
        return PrintEntities.UserToString(test);
    }
    private String findResidenceToString(String id){
        ResidenceSem test = testResidence(id);
        if (test == null){
            return "Residence not exists.";
        }
        result.setStyleName(ValoTheme.LABEL_SUCCESS);
         return PrintEntities.ResidenceToString(test);
    }
    private String findPurchaseToString(String id){
        PurchaseSem test = testPurchase(id);
        if (test == null){
            return "Purchase not exists.";
        }
        result.setStyleName(ValoTheme.LABEL_SUCCESS);
         return PrintEntities.PurchaseToString(test);
    }
    
    public ItemsSem testItem (String id){
        result.setStyleName(ValoTheme.LABEL_FAILURE);
        if (!isNumeric(id)){
            return null;
        }
        ItemsSem test = itemClient.find_JSON(ItemsSem.class, id);
        if (test == null){
                return null;
        }
        return test;
    }
    public UsersSem testUser (String id){
        result.setStyleName(ValoTheme.LABEL_FAILURE);
        if (!isNumeric(id)){
            return null;
        }
        UsersSem test = userClient.find_JSON(UsersSem.class, id);
        if (test == null){
                return null;
        }
        return test;
    }
    public ResidenceSem testResidence (String id){
        result.setStyleName(ValoTheme.LABEL_FAILURE);
        if (!isNumeric(id)){
            return null;
        }
        ResidenceSem test = residenceClient.find_JSON(ResidenceSem.class, id);
        if (test == null){
                return null;
        }
        return test;
    }
    public PurchaseSem testPurchase (String id){
        result.setStyleName(ValoTheme.LABEL_FAILURE);
        if (!isNumeric(id))
            return null;
        PurchaseSem test = purchaseClient.find_JSON(PurchaseSem.class, id);
        if (test == null)
                return null;
        return test;
    }
    
    
    public static boolean isNumeric(String s){
        return s != null && s.matches("\\d+");
    }
}
