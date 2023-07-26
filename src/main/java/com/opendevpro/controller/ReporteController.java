package com.opendevpro.controller;

import com.opendevpro.model.Reporte;
import com.opendevpro.model.Venta;
import com.opendevpro.service.interfaces.IReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private IReporteService iReporteService;

    public ReporteController(IReporteService iReporteService) {
        this.iReporteService = iReporteService;
    }

    @GetMapping()
    public  ResponseEntity<List<Reporte>> verVentasDeLosUltimosDoceMeses(){
        return ResponseEntity.ok(this.iReporteService.obtenerReporteDeLosUltimosDoceMeses());
    }
}
