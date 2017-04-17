package by.hrychanok.training.shop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Oil.class)
public abstract class Oil_ extends by.hrychanok.training.shop.model.Product_ {

	public static volatile SingularAttribute<Oil, Integer> volume;
	public static volatile SingularAttribute<Oil, String> viscosity;
	public static volatile SingularAttribute<Oil, OilDestination> oilDestination;
	public static volatile SingularAttribute<Oil, OilType> oilType;
	public static volatile SingularAttribute<Oil, OilComposition> oilComposition;

}

