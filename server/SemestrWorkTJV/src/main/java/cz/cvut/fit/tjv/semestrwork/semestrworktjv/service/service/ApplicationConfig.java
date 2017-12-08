/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.tjv.semestrwork.semestrworktjv.service.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author dibik
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cz.cvut.fit.tjv.semestrwork.semestrworktjv.service.service.ItemsSemFacadeREST.class);
        resources.add(cz.cvut.fit.tjv.semestrwork.semestrworktjv.service.service.PurchaseSemFacadeREST.class);
        resources.add(cz.cvut.fit.tjv.semestrwork.semestrworktjv.service.service.ResidenceSemFacadeREST.class);
        resources.add(cz.cvut.fit.tjv.semestrwork.semestrworktjv.service.service.UsersSemFacadeREST.class);
    }
    
}
