package cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities;

import cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.PurchaseSem;
import cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.ResidenceSem;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-08T10:03:39")
@StaticMetamodel(UsersSem.class)
public class UsersSem_ { 

    public static volatile SingularAttribute<UsersSem, String> firstname;
    public static volatile ListAttribute<UsersSem, PurchaseSem> purchases;
    public static volatile SingularAttribute<UsersSem, String> surname;
    public static volatile SingularAttribute<UsersSem, Long> users_id;
    public static volatile SingularAttribute<UsersSem, ResidenceSem> residence;
    public static volatile SingularAttribute<UsersSem, Integer> personal_id_number;

}