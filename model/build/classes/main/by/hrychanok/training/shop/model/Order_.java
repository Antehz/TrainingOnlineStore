package by.hrychanok.training.shop.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ extends by.hrychanok.training.shop.model.AbstractModel_ {

	public static volatile SingularAttribute<Order, Integer> totalPrice;
	public static volatile SingularAttribute<Order, ShippingMethod> shippingMethod;
	public static volatile SingularAttribute<Order, String> additionalInfo;
	public static volatile SingularAttribute<Order, Date> startDate;
	public static volatile SingularAttribute<Order, StatusOrder> status;
	public static volatile SingularAttribute<Order, Customer> customer;
	public static volatile ListAttribute<Order, OrderContent> orderContent;

}

