package com.opendevpro.service.interfaces;

import com.opendevpro.model.Auto;

import java.util.List;
import java.util.Optional;

public interface IAutoService {
    Auto crearAuto(Auto auto);
    Auto buscarAutoPorId(Integer id);
    Auto buscarAutoConStockPorId(Integer id);
    List<Auto> obtenerTodosLosAutos();
    List<Auto> obtenerTodosLosAutosConStock();
    List<Auto> obtenerTodosLosAutosConStock(String order, String tipo);
    void eliminarAuto(Integer id);
    Auto descontarStockDelAuto(Integer id, Integer stock);
    Auto modificarStockDelAutoDisponible(Integer id, Integer stock);
}
