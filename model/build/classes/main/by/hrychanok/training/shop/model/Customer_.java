package by.hrychanok.training.shop.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ extends by.hrychanok.training.shop.model.AbstractModel_ {

	public static volatile SingularAttribute<Customer, String> lastName;
	public static volatile SingularAttribute<Customer, String> country;
	public static volatile SingularAttribute<Customer, String> zipCode;
	public static volatile SingularAttribute<Customer, String> address;
	public static volatile SingularAttribute<Customer, Gender> gender;
	public static volatile SingularAttribute<Customer, String> city;
	public static volatile SingularAttribute<Customer, Date> created;
	public static volatile SingularAttribute<Customer, CustomerCredentials> customerCredentials;
	public static volatile SingularAttribute<Customer, byte[]> photo;
	public static volatile ListAttribute<Customer, CartContent> cartContent;
	public static volatile SingularAttribute<Customer, String> firstName;
	public static volatile SingularAttribute<Customer, Date> dateBirth;
	public static volatile ListAttribute<Customer, ProductComment> productComment;
	public static volatile SingularAttribute<Customer, String> email;
	public static volatile ListAttribute<Customer, Order> order;

}

