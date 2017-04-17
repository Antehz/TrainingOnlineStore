package by.hrychanok.training.shop.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductComment.class)
public abstract class ProductComment_ extends by.hrychanok.training.shop.model.AbstractModel_ {

	public static volatile SingularAttribute<ProductComment, Date> date;
	public static volatile SingularAttribute<ProductComment, Product> product;
	public static volatile SingularAttribute<ProductComment, String> comment;
	public static volatile SingularAttribute<ProductComment, Customer> customer;

}

