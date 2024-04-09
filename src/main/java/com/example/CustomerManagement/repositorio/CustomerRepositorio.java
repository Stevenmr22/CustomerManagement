package com.example.CustomerManagement.repositorio;

import com.example.CustomerManagement.entidades.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositorio extends JpaRepository<Customer, Long> {
}
