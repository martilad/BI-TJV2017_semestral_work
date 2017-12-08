package cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities;

import cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.PurchaseSem;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-08T10:03:39")
@StaticMetamodel(ItemsSem.class)
public class ItemsSem_ { 

    public static volatile SingularAttribute<ItemsSem, Long> item_id;
    public static volatile ListAttribute<ItemsSem, PurchaseSem> purchases;
    public static volatile SingularAttribute<ItemsSem, String> item_name;
    public static volatile SingularAttribute<ItemsSem, Integer> item_prize;

}