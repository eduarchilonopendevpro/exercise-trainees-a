package com.opendevpro.service.interfaces;

import com.opendevpro.model.Reporte;
import com.opendevpro.model.Venta;

import java.util.List;

public interface IReporteService {
    List<Reporte> obtenerReporteDeLosUltimosDoceMeses();
}
