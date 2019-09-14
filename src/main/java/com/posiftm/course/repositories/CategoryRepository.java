package com.posiftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posiftm.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
