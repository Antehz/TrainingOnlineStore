package by.hrychanok.training.shop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CarBattery.class)
public abstract class CarBattery_ extends by.hrychanok.training.shop.model.Product_ {

	public static volatile SingularAttribute<CarBattery, Integer> cca;
	public static volatile SingularAttribute<CarBattery, BatteryType> batteryType;
	public static volatile SingularAttribute<CarBattery, Integer> voltage;
	public static volatile SingularAttribute<CarBattery, Integer> capacity;
	public static volatile SingularAttribute<CarBattery, Polarity> polarity;

}

