package com.example.CustomerManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDto {
    private long id;
    private String nombre;
    private String nombreContacto;
    private String rnc;
    private String direccion;
    private String telefono;
    private String telefono2;
    private String email;
}
