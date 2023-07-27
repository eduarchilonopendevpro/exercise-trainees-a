package com.opendevpro.service.interfaces;

import com.opendevpro.exception.AutoFoundException;
import com.opendevpro.exception.AutoNotFoundException;
import com.opendevpro.model.Auto;

import java.util.List;

public interface IAutoService {
    Auto crearAuto(Auto auto) throws AutoFoundException;
    Auto buscarAutoPorId(Integer id) throws AutoNotFoundException;
    Auto buscarAutoConStockPorId(Integer id) throws AutoNotFoundException;
    List<Auto> obtenerTodosLosAutos();
    List<Auto> obtenerTodosLosAutosConStock();
    List<Auto> obtenerTodosLosAutosConStock(String order, String tipo);
    void eliminarAuto(Integer id);
    Auto descontarStockDelAuto(Integer id, Integer stock);
    Auto modificarStockDelAutoDisponible(Integer id, Integer stock);
}
