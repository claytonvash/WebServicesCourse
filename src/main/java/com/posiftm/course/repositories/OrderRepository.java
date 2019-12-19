package com.posiftm.course.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posiftm.course.entities.Order;
import com.posiftm.course.entities.User;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	List<Order> findByClient(User client);

}
