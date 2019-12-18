package com.posiftm.course.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.posiftm.course.dto.CategoryDTO;
import com.posiftm.course.dto.ProductCategoriesDTO;
import com.posiftm.course.dto.ProductDTO;
import com.posiftm.course.entities.Category;
import com.posiftm.course.entities.Product;
import com.posiftm.course.repositories.CategoryRepository;
import com.posiftm.course.repositories.ProductRepository;
import com.posiftm.course.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAll();		
		return list.stream().map(e -> new ProductDTO(e)).collect(Collectors.toList());
	}
	
	public ProductDTO findById(Long id) {
		Optional<Product> obj = repository.findById(id);		
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new ProductDTO(entity);
	
	}
	@Transactional
	public ProductDTO insert(ProductCategoriesDTO dto) {
		Product entity = dto.toEntity();
		setProductCategories(entity,dto.getCategories());
		entity =  repository.save(entity);
		return new ProductDTO(entity);

	}

	private void setProductCategories(Product entity, List<CategoryDTO> categories) {
		entity.getCategories().clear();
		for (CategoryDTO dto : categories) {
			Category category = categoryRepository.getOne(dto.getId());
			entity.getCategories().add(category);
		}
		
	}

}
