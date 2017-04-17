package by.hrychanok.training.shop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CustomerCredentials.class)
public abstract class CustomerCredentials_ extends by.hrychanok.training.shop.model.AbstractModel_ {

	public static volatile SingularAttribute<CustomerCredentials, String> password;
	public static volatile SingularAttribute<CustomerCredentials, UserRole> role;
	public static volatile SingularAttribute<CustomerCredentials, String> login;
	public static volatile SingularAttribute<CustomerCredentials, Customer> customer;

}

