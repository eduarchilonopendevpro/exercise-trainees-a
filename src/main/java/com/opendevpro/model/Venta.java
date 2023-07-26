package com.opendevpro.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer autoId;
    private LocalDate fechaVenta; //yyyy-mm-dd
    private Integer cantidad;
    private String comprador;

    public Venta(){}

    public Venta(Integer id, Integer autoId, LocalDate fechaVenta, Integer cantidad, String comprador) {
        this.id = id;
        this.autoId = autoId;
        this.fechaVenta = fechaVenta;
        this.cantidad = cantidad;
        this.comprador = comprador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", autoId=" + autoId +
                ", fechaVenta=" + fechaVenta +
                ", cantidad=" + cantidad +
                ", comprador='" + comprador + '\'' +
                '}';
    }
}
