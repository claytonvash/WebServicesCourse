package com.posiftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posiftm.course.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
