package cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.semestrworktjvclient;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.ItemsSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.PurchaseSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.ResidenceSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.dto.UsersSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.ItemClient;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.PurchaseClient;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.ResidenceClient;
import cz.cvut.fit.tjv.semestrwork.semestrworktjvclient.services.UserClient;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    private ItemClient itemClient = new ItemClient();
    private UserClient userClient = new UserClient();
    private ResidenceClient residenceClient = new ResidenceClient();
    private PurchaseClient purchaseClient = new PurchaseClient();
    private Label itemLabel = new Label("", ContentMode.PREFORMATTED);
    private Label userLabel = new Label("", ContentMode.PREFORMATTED);
    private Label residenceLabel = new Label("", ContentMode.PREFORMATTED);
    private Label purchaseLabel = new Label("", ContentMode.PREFORMATTED);
    private RemoveFindEntities removeLayout;
    private CreateUpdateEntities createLayout;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        HorizontalLayout printLayout = new HorizontalLayout();
        HorizontalLayout printLayout2 = new HorizontalLayout();
        removeLayout = new RemoveFindEntities(itemClient, userClient, residenceClient, purchaseClient, this);
        createLayout = new CreateUpdateEntities(itemClient, userClient, residenceClient, purchaseClient, this);
        printLayout.addComponent(itemLabel);
        printLayout.addComponent(userLabel);
        printLayout2.addComponent(residenceLabel);
        printLayout2.addComponent(purchaseLabel);
        layout.addComponent(removeLayout.getLayout()); 
        layout.addComponent(createLayout.getLayout());
        layout.addComponent(printLayout);
        layout.setComponentAlignment(printLayout, Alignment.MIDDLE_CENTER);
        layout.addComponent(printLayout2);
        layout.setComponentAlignment(printLayout2, Alignment.MIDDLE_CENTER);
        itemLabel.setCaption("Items:");
        userLabel.setCaption("Users:");
        residenceLabel.setCaption("Residence:");
        purchaseLabel.setCaption("Purchase:");
        RefreshPrint();
              
        
        
       final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"+ itemClient.countREST()));
            
            ItemsSem item = new ItemsSem();
            item.setItem_name("Test");
            item.setItem_prize("20");
            itemClient.create_JSON(item);
            
            ResidenceSem residence = new ResidenceSem();
            residence.setCity("pravekov");
            residence.setStreet("jeskyne");
            residence.setStreet_number("452");
            residence.setZip_code("36301");
            residenceClient.create_JSON(residence);
            
            UsersSem user = new UsersSem();
            user.setFirstname("Lada");
            user.setSurname("Mart");
            user.setPersonal_id_number("45244");
            user.setResidence(residence);
            userClient.create_JSON(user);
            
            PurchaseSem purchase = new PurchaseSem();
            purchase.setDate_purchase("15.3.2017");
            purchase.setItem_id(item);
            purchase.setUser_id(user);
            purchaseClient.create_JSON(purchase);
            
            
            
            
            
            ItemsSem item211 = itemClient.find_JSON(ItemsSem.class, "211");
            ItemsSem test = itemClient.find_JSON(ItemsSem.class, "214588");
            if (test == null){
                System.out.println("TOto je b8je4n0 a bude se s tim dob5e pracovat");
            }
            item211.setItem_prize("1255");
            itemClient.edit_JSON(item211, "211");
            RefreshPrint(); 
        });
        layout.addComponents(name, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
    public void RefreshPrint(){
        PrintEntities.setItems(itemLabel, itemClient);
        PrintEntities.setUsers(userLabel, userClient);
        PrintEntities.setResidences(residenceLabel, residenceClient);
        PrintEntities.setPurchases(purchaseLabel, purchaseClient);
        
    }
}
