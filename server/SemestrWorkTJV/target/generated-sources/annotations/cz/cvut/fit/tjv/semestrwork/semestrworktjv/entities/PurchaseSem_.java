package cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities;

import cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.ItemsSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.UsersSem;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-08T10:03:39")
@StaticMetamodel(PurchaseSem.class)
public class PurchaseSem_ { 

    public static volatile SingularAttribute<PurchaseSem, String> date_purchase;
    public static volatile SingularAttribute<PurchaseSem, UsersSem> user_id;
    public static volatile SingularAttribute<PurchaseSem, ItemsSem> item_id;
    public static volatile SingularAttribute<PurchaseSem, Long> purchase_id;

}