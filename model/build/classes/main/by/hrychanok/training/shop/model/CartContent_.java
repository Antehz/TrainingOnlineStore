package by.hrychanok.training.shop.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CartContent.class)
public abstract class CartContent_ extends by.hrychanok.training.shop.model.AbstractModel_ {

	public static volatile SingularAttribute<CartContent, Product> product;
	public static volatile SingularAttribute<CartContent, Integer> amount;
	public static volatile SingularAttribute<CartContent, Date> dateAdd;
	public static volatile SingularAttribute<CartContent, Integer> price;
	public static volatile SingularAttribute<CartContent, Customer> customer;

}

