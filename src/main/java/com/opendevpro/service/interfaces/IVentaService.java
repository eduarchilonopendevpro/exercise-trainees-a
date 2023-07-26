package com.opendevpro.service.interfaces;

import com.opendevpro.model.Venta;

import java.util.List;

public interface IVentaService {
    Venta createVenta(Venta venta);
    List<Venta> obtenerTodasLasVentas();
}
