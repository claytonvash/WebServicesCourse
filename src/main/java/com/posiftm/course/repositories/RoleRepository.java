package com.posiftm.course.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posiftm.course.entities.OrderItem;
import com.posiftm.course.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	void saveAll(List<OrderItem> asList);

}
