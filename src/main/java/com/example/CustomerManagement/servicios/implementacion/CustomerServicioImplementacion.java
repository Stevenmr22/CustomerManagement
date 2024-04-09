package com.example.CustomerManagement.servicios.implementacion;

import com.example.CustomerManagement.dto.CustomerDto;
import com.example.CustomerManagement.exception.RecursoNoEncontrado;
import com.example.CustomerManagement.repositorio.CustomerRepositorio;
import com.example.CustomerManagement.servicios.CustomerServicio;
import com.example.CustomerManagement.entidades.Customer;
import com.example.CustomerManagement.Mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServicioImplementacion implements CustomerServicio {

    private CustomerRepositorio customerRepositorio;
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer customerGuardado = customerRepositorio.save(customer);
        return CustomerMapper.mapToCustomerDto(customerGuardado);
    }
    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("El cliente con el id: " + id + " no existe"));
        return CustomerMapper.mapToCustomerDto(customer);
    }
    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepositorio.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return customers.stream()
                .map(CustomerMapper::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerActualizado) {
        Customer customer = customerRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("El cliente con el id: " + id + " no existe"));
        customer.setNombre(customerActualizado.getNombre());
        customer.setNombreContacto(customerActualizado.getNombreContacto());
        customer.setRNC(customerActualizado.getRnc());
        customer.setDireccion(customerActualizado.getDireccion());
        customer.setTelefono(customerActualizado.getTelefono());
        customer.setTelefono2(customerActualizado.getTelefono2());
        customer.setEmail(customerActualizado.getEmail());

        Customer ObjetocustomerActualizado = customerRepositorio.save(customer);

        return CustomerMapper.mapToCustomerDto(ObjetocustomerActualizado);
    }
    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("El cliente con el id: " + id + " no existe"));
        customerRepositorio.deleteById(id);
    }
}
