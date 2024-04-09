package com.example.CustomerManagement.controladores;

import com.example.CustomerManagement.dto.CustomerDto;
import com.example.CustomerManagement.servicios.CustomerServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerServicio customerService;

    public CustomerController(CustomerServicio customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<CustomerDto> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "listar-customer"; // Devuelve el nombre de la vista HTML
    }

    @GetMapping("/crear-customer")
    public String createCustomerForm(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "crear-customer"; // Devuelve el nombre de la vista HTML
    }
    @PostMapping("/editar-customer")
    public String updateCustomer(@ModelAttribute("customer") CustomerDto customerDto) {
        customerService.updateCustomer(customerDto.getId(), customerDto);
        return "redirect:/customers"; // Redirige al usuario a la lista de clientes después de actualizar un cliente
    }

    @GetMapping("/editar-customer/{id}")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        CustomerDto customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "editar-customer"; // Devuelve el nombre de la vista HTML
    }

    @GetMapping("/")
    public String index() {
        return "index"; // Devuelve el nombre de la vista HTML
    }
}
