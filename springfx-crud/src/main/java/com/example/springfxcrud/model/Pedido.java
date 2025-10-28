package com.example.springfxcrud.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaHora;
    @ManyToOne
    private Cliente cliente;
    private String tipoPedido;
    private Double total;
    private Double costoEnvio;
    private Double impuesto;
    private String tipoPago;
    private String estado;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detalles;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public LocalDateTime getFechaHora(){return fechaHora;} public void setFechaHora(LocalDateTime fechaHora){this.fechaHora=fechaHora;}
    public Cliente getCliente(){return cliente;} public void setCliente(Cliente cliente){this.cliente=cliente;}
    public String getTipoPedido(){return tipoPedido;} public void setTipoPedido(String tipoPedido){this.tipoPedido=tipoPedido;}
    public Double getTotal(){return total;} public void setTotal(Double total){this.total=total;}
    public Double getCostoEnvio(){return costoEnvio;} public void setCostoEnvio(Double costoEnvio){this.costoEnvio=costoEnvio;}
    public Double getImpuesto(){return impuesto;} public void setImpuesto(Double impuesto){this.impuesto=impuesto;}
    public String getTipoPago(){return tipoPago;} public void setTipoPago(String tipoPago){this.tipoPago=tipoPago;}
    public String getEstado(){return estado;} public void setEstado(String estado){this.estado=estado;}
    public Usuario getUsuario(){return usuario;} public void setUsuario(Usuario usuario){this.usuario=usuario;}
    public java.util.List<DetallePedido> getDetalles(){return detalles;} public void setDetalles(java.util.List<DetallePedido> detalles){this.detalles=detalles;}
}
