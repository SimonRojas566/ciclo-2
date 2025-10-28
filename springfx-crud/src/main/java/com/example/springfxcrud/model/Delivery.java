package com.example.springfxcrud.model;

import jakarta.persistence.*;

@Entity
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pedido pedido;
    @ManyToOne
    private Repartidor repartidor;
    private String direccionEntrega;
    private String horaAsignacion;
    private String horaSalida;
    private String horaEntrega;
    private String observaciones;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Pedido getPedido(){return pedido;} public void setPedido(Pedido pedido){this.pedido=pedido;}
    public Repartidor getRepartidor(){return repartidor;} public void setRepartidor(Repartidor repartidor){this.repartidor=repartidor;}
    public String getDireccionEntrega(){return direccionEntrega;} public void setDireccionEntrega(String direccionEntrega){this.direccionEntrega=direccionEntrega;}
    public String getHoraAsignacion(){return horaAsignacion;} public void setHoraAsignacion(String horaAsignacion){this.horaAsignacion=horaAsignacion;}
    public String getHoraSalida(){return horaSalida;} public void setHoraSalida(String horaSalida){this.horaSalida=horaSalida;}
    public String getHoraEntrega(){return horaEntrega;} public void setHoraEntrega(String horaEntrega){this.horaEntrega=horaEntrega;}
    public String getObservaciones(){return observaciones;} public void setObservaciones(String observaciones){this.observaciones=observaciones;}
}
