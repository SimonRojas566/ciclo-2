package com.example.springfxcrud.model;

import jakarta.persistence.*;

@Entity
public class Repartidor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String vehiculo;
    private Boolean disponibilidad;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getNombre(){return nombre;} public void setNombre(String nombre){this.nombre=nombre;}
    public String getTelefono(){return telefono;} public void setTelefono(String telefono){this.telefono=telefono;}
    public String getVehiculo(){return vehiculo;} public void setVehiculo(String vehiculo){this.vehiculo=vehiculo;}
    public Boolean getDisponibilidad(){return disponibilidad;} public void setDisponibilidad(Boolean disponibilidad){this.disponibilidad=disponibilidad;}
}
