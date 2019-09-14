package com.posiftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posiftm.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
