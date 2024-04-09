package com.example.CustomerManagement.Mapper;

import com.example.CustomerManagement.dto.CustomerDto;
import com.example.CustomerManagement.entidades.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer){
        return new CustomerDto(
            customer.getId(),
            customer.getNombre(),
            customer.getNombreContacto(),
            customer.getRNC(),
            customer.getDireccion(),
            customer.getTelefono(),
            customer.getTelefono2(),
            customer.getEmail()
        );
    }
    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
            customerDto.getId(),
            customerDto.getNombre(),
            customerDto.getNombreContacto(),
            customerDto.getRnc(),
            customerDto.getDireccion(),
            customerDto.getTelefono(),
            customerDto.getTelefono2(),
            customerDto.getEmail()
        );
    }
}
