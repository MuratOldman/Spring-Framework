package com.example.repository;

import com.example.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
