package by.hrychanok.training.shop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderContent.class)
public abstract class OrderContent_ extends by.hrychanok.training.shop.model.AbstractModel_ {

	public static volatile SingularAttribute<OrderContent, Integer> amount;
	public static volatile SingularAttribute<OrderContent, Product> product;
	public static volatile SingularAttribute<OrderContent, Integer> price;
	public static volatile SingularAttribute<OrderContent, Order> order;

}

