package com.gcu.gamehive_cloud.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity tells JPA that this class maps to the gamehive_cloud database
@Entity
@Table(name="products")

public class Product {
	// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private String name;
	
	// For Games, Console, or Accessories
	private String category;
	
	// Types of Devices (i.e PS5, Xbox, Switch)
	private String platform;
	
	// Exact money amount in BigDecimal
	private BigDecimal price;
	
	private Integer stock;
	
	// @Column which maps to the esrb_rating column
	@Column(name="esrb_rating")
	private String esrbRating;
	
	// Empty Constructor for rows
	public Product() {}

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getEsrbRating() {
		return esrbRating;
	}

	public void setEsrbRating(String esrbRating) {
		this.esrbRating = esrbRating;
	}
	
	
}
