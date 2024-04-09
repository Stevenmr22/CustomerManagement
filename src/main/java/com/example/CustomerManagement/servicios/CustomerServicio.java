package com.example.CustomerManagement.servicios;

import com.example.CustomerManagement.dto.CustomerDto;

import java.util.List;

public interface CustomerServicio {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(Long id);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long id, CustomerDto customerActualizado);
    void deleteCustomer(Long id);
}
