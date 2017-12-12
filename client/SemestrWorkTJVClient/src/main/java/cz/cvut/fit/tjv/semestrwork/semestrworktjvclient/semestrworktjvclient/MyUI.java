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
