package io.hackages.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 64, nullable = false, unique = true)
	private String name;

	@Column
	private float price;

	private LocalDate createdAt;

	private LocalDateTime updatedAt;

	private ProductCategory productCategory;

	public Product() {
		createdAt = LocalDate.now();
		updatedAt = LocalDateTime.now();
	}	

	public Product(String name, float price) {

		this(null, name, price);
	}

	public Product(Integer id) {
		this.id = id;
	}
	
	public Product(Integer id, String name, float price) {
		this();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
}
