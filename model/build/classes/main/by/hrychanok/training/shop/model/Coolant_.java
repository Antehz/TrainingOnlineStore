package by.hrychanok.training.shop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Coolant.class)
public abstract class Coolant_ extends by.hrychanok.training.shop.model.Product_ {

	public static volatile SingularAttribute<Coolant, Integer> volume;
	public static volatile SingularAttribute<Coolant, FluidState> fluidState;
	public static volatile SingularAttribute<Coolant, CoolantColor> color;

}

