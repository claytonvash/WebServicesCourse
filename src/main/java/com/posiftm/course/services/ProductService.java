package com.posiftm.course.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posiftm.course.dto.ProductDTO;
import com.posiftm.course.entities.Product;
import com.posiftm.course.repositories.ProductRepository;
import com.posiftm.course.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAll();		
		return list.stream().map(e -> new ProductDTO(e)).collect(Collectors.toList());
	}
	
	public ProductDTO findById(Long id) {
		Optional<Product> obj = repository.findById(id);		
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new ProductDTO(entity);
	
	}

}
