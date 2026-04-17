package com.crm.crm_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crm.crm_backend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNameContainingIgnoreCase(String name);
}
