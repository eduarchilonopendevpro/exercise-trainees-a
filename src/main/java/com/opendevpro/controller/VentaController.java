package com.opendevpro.controller;
import com.opendevpro.component.VentaValidator;
import com.opendevpro.exception.AutoNotFoundException;
import com.opendevpro.model.Venta;
import com.opendevpro.service.interfaces.IVentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final Logger logger = LoggerFactory.getLogger(VentaController.class);
    private IVentaService iVentaService;

    private VentaValidator ventaValidator;

    @Autowired
    public VentaController(IVentaService iVentaService, VentaValidator ventaValidator) {
        this.iVentaService = iVentaService;
        this.ventaValidator = ventaValidator;
    }

    @PostMapping()
    public ResponseEntity<String> crearUnaVenta(@RequestBody Venta venta, BindingResult bindingResult){
        this.ventaValidator.validate(venta, bindingResult);
        if (!bindingResult.hasErrors()){
            try {
                this.iVentaService.createVenta(venta);
                logger.info("OK = VentaController.crearUnaVenta(): " + venta);
                return ResponseEntity.ok("Venta creada con exito.");
            }catch (AutoNotFoundException ex){
                logger.error("ERROR = VentaController.crearUnaVenta(): " + ex.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            }
        }else {
            return ResponseEntity.badRequest()
                    .body("Error: " + bindingResult.getFieldError().getField());
        }
    }

    @GetMapping()
    public ResponseEntity<List<Venta>> verTodasLaVentas(){
        List<Venta> ventas = this.iVentaService.obtenerTodasLasVentas();
        return ResponseEntity.ok(ventas);
    }
}
