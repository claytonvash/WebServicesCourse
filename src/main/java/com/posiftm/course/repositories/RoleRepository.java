package com.posiftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posiftm.course.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
