package com.posiftm.course.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.posiftm.course.entities.Product;

public class ProductDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	private List<CategoryDTO> categories = new ArrayList<>();
	

	public ProductDTO(Long id, String name, String description, Double price, String imgUrl, List<CategoryDTO> categories) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.categories = categories;
		
	}


	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
		this.categories = entity.getCategories().stream().map(e -> new CategoryDTO(e)).collect(Collectors.toList());		
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public List<CategoryDTO> getCategories() {
		return categories;
	}


	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Product toEntity() {
		return new Product(null, name, description, price, imgUrl);
	}
}


