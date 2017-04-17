package by.hrychanok.training.shop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ extends by.hrychanok.training.shop.model.AbstractModel_ {

	public static volatile SingularAttribute<Product, Integer> countOrder;
	public static volatile SingularAttribute<Product, Integer> price;
	public static volatile SingularAttribute<Product, String> imageURL;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, Integer> available;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, String> model;
	public static volatile ListAttribute<Product, ProductComment> productComment;
	public static volatile SingularAttribute<Product, Category> category;
	public static volatile ListAttribute<Product, OrderContent> orderContent;
	public static volatile SingularAttribute<Product, String> manufacturer;
	public static volatile SingularAttribute<Product, Integer> countRecommended;

}

