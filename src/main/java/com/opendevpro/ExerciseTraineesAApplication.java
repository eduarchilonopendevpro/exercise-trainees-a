package com.opendevpro;

import com.opendevpro.model.Auto;
import com.opendevpro.model.Reporte;
import com.opendevpro.model.Venta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class ExerciseTraineesAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseTraineesAApplication.class, args);
//
//		LocalDate fecha = LocalDate.now();
//		Venta venta = new Venta(1, 2,  fecha, 4, "Eduar");
//
//		System.out.println(venta.toString());
//
//		LocalDate fechaActual = LocalDate.now();
//		LocalDate fechaHace12Meses = fechaActual.minusMonths(12);

        /*List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, 2, LocalDate.of(2021, 3, 24), 2, "Juan Pérez"));
        ventas.add(new Venta(2, 2, LocalDate.of(2022, 8, 01), 3, "Juan Pérez"));
        ventas.add(new Venta(3, 2, LocalDate.of(2022, 8, 24), 2, "Juan Pérez"));
        ventas.add(new Venta(4, 2, LocalDate.of(2023, 7, 24), 2, "Juan Pérez"));
        ventas.add(new Venta(5, 2, LocalDate.of(2022, 8, 22), 2, "Juan Pérez"));
        ventas.add(new Venta(6, 2, LocalDate.of(2023, 1, 24), 2, "Juan Pérez"));
        ventas.add(new Venta(7, 2, LocalDate.of(2022, 7, 02), 7, "Juan Pérez"));
        ventas.add(new Venta(8, 2, LocalDate.of(2022, 7, 02), 3, "Juan Pérez"));

        List<Auto> autos = new ArrayList<>();
        autos.add(new Auto(2, 100.0));


        List<Venta> filtradosPorFecha = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
        LocalDate fechaHace12Meses = fechaActual.minusMonths(12);

        System.out.println(fechaHace12Meses + "  " + fechaActual);
        for (Venta v : ventas) {
            if (v.getFechaVenta()
                    .isAfter(fechaHace12Meses)) {
                System.out.println(v);
                filtradosPorFecha.add(v);
            }
        }
        System.out.println("-----------------");

        List<Reporte> listaReportes = new ArrayList<>();

        for (Venta venta : filtradosPorFecha) {
            Auto auto = null;
            for (Auto a : autos) {
                if (a.getId() == venta.getAutoId()) {
                    auto = a;
                }
            }

            if (auto != null) {
                double montoVenta = venta.getCantidad() * auto.getPrice();

                listaReportes.add(new Reporte(
                        venta.getFechaVenta().getMonthValue(),
                        venta.getFechaVenta().getYear(),
                        montoVenta, 4));
            }
        }

        for (Reporte r: listaReportes) {
            System.out.println(r);
        }

        System.out.println("-------");

        Map<String, Reporte> reportesAgrupados = new HashMap<>();

        for (Reporte reporte : listaReportes) {
            String key = reporte.getMonth() + "-" + reporte.getYear();
            if (reportesAgrupados.containsKey(key)) {
                Reporte reporteExistente = reportesAgrupados.get(key);
                reporteExistente.setVentasTotales(reporteExistente.getVentasTotales() + reporte.getVentasTotales());
                reporteExistente.setCantidadAutosVendidos(reporteExistente.getCantidadAutosVendidos() + reporte.getCantidadAutosVendidos());
            } else {
                reportesAgrupados.put(key, reporte);
            }
        }

        // Resultados
        for (Reporte reporte : reportesAgrupados.values()) {
            System.out.println(reporte);
        }*/
    }

}
