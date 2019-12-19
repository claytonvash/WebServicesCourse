package com.posiftm.course.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posiftm.course.entities.OrderItem;
import com.posiftm.course.entities.Role;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	void saveAll(List<Role> asList);

}
