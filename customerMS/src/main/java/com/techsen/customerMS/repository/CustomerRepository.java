package com.techsen.customerMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsen.customerMS.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
