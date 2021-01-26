package app.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Product.java This is a model class represent a Product entity
 * 
 * @author Phong Van Nguyen
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;

	@Column(name = "product_name")
	private String name;
	
	@Column(name = "product_size")
	private int size;

	public Product() {
		
	}
	
	public Product(String name, int size) {
		this.name = name;
		this.size = size;
	}

	
	
	
	
}
