package com.opendevpro.service;

import com.opendevpro.model.Auto;
import com.opendevpro.model.Reporte;
import com.opendevpro.model.Venta;
import com.opendevpro.repository.IAutoRepository;
import com.opendevpro.repository.IVentaRepository;
import com.opendevpro.service.interfaces.IReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReporteService implements IReporteService {

    private IVentaRepository iVentaRepository;
    private IAutoRepository iAutoRepository;

    @Autowired
    public ReporteService(IVentaRepository iVentaRepository, IAutoRepository iAutoRepository) {
        this.iVentaRepository = iVentaRepository;
        this.iAutoRepository = iAutoRepository;
    }

    @Override
    public List<Reporte> obtenerReporteDeLosUltimosDoceMeses() {

        //Obtengo la fecha del mes incusive hace doce meses
        List<Venta> ventasFiltrasPorFecha = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
        LocalDate fechaHace12Meses = fechaActual.minusMonths(12);

        //filtro las ventas que estan en el rango de los 12 meses
        for (Venta v : this.iVentaRepository.findAll()) {
            if (v.getFechaVenta()
                    .isAfter(fechaHace12Meses)) {
                ventasFiltrasPorFecha.add(v);
            }
        }

        List<Reporte> listaReportesSinUnificar = new ArrayList<>();

        //Busco los autos que estan dentro de cada venta
        for (Venta venta : ventasFiltrasPorFecha) {
            Auto auto = null;
            for (Auto a : this.iAutoRepository.findAll()) {
                if (a.getId() == venta.getAutoId()) {
                    auto = a;
                }
            }

            //Si estan, multiplico la cantidad vendida por el precio del auto
            if (auto != null) {
                Double montoVenta = venta.getCantidad() * auto.getPrice();
                listaReportesSinUnificar.add(new Reporte(
                        venta.getFechaVenta().getMonthValue(),
                        venta.getFechaVenta().getYear(),
                        montoVenta, venta.getCantidad()));
            }
        }

        Map<String, Reporte> reportesAgrupados = new TreeMap<>();

        for (Reporte reporte : listaReportesSinUnificar) {
            String key = reporte.getMonth() + "-" + reporte.getYear(); //creo una key formateada de la fecha
            if (reportesAgrupados.containsKey(key)) {
                Reporte reporteExistente = reportesAgrupados.get(key);
                reporteExistente.setVentasTotales(reporteExistente.getVentasTotales() + reporte.getVentasTotales());
                reporteExistente.setCantidadAutosVendidos(reporteExistente.getCantidadAutosVendidos() + reporte.getCantidadAutosVendidos());
            } else {
                reportesAgrupados.put(key, reporte);
            }
        }
        return reportesAgrupados.values().stream()
                .sorted((x, y) -> x.getYear().compareTo(y.getYear()))
                .collect(Collectors.toList());
    }
}
