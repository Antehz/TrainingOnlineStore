package by.hrychanok.training.shop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ extends by.hrychanok.training.shop.model.AbstractModel_ {

	public static volatile SingularAttribute<Category, Category> parent;
	public static volatile SingularAttribute<Category, String> nameEng;
	public static volatile ListAttribute<Category, Category> children;
	public static volatile SingularAttribute<Category, String> name;
	public static volatile SingularAttribute<Category, String> description;

}

