package by.hrychanok.training.shop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScreenWash.class)
public abstract class ScreenWash_ extends by.hrychanok.training.shop.model.Product_ {

	public static volatile SingularAttribute<ScreenWash, Integer> volume;
	public static volatile SingularAttribute<ScreenWash, FluidState> fluidState;
	public static volatile SingularAttribute<ScreenWash, Season> washSeason;
	public static volatile SingularAttribute<ScreenWash, Integer> temperature;
	public static volatile SingularAttribute<ScreenWash, String> countryManufacturer;

}

