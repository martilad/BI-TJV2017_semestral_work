package cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities;

import cz.cvut.fit.tjv.semestrwork.semestrworktjv.entities.UsersSem;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-08T10:03:39")
@StaticMetamodel(ResidenceSem.class)
public class ResidenceSem_ { 

    public static volatile SingularAttribute<ResidenceSem, Long> residence_id;
    public static volatile SingularAttribute<ResidenceSem, String> city;
    public static volatile SingularAttribute<ResidenceSem, String> street;
    public static volatile SingularAttribute<ResidenceSem, Integer> street_number;
    public static volatile SingularAttribute<ResidenceSem, Integer> zip_code;
    public static volatile ListAttribute<ResidenceSem, UsersSem> users;

}