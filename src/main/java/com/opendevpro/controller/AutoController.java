package com.opendevpro.controller;

import com.opendevpro.component.AutoValidator;
import com.opendevpro.exception.AutoFoundException;
import com.opendevpro.exception.AutoNotFoundException;
import com.opendevpro.model.Auto;
import com.opendevpro.service.interfaces.IAutoService;
import com.opendevpro.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/autos")
public class AutoController {


    private final Logger logger = LoggerFactory.getLogger(AutoController.class);
    private AutoValidator autoValidator;
    private IAutoService iAutoService;

    @Autowired
    public AutoController(AutoValidator autoValidator, IAutoService autoService) {
        this.autoValidator = autoValidator;
        this.iAutoService = autoService;
    }

    @GetMapping()
    public ResponseEntity<List<Auto>> verTodosLosAutosEnStock(
            @RequestParam(required = false) String order,
            @RequestParam(required = false) String tipo) {
        List<Auto> autos = this.iAutoService.obtenerTodosLosAutosConStock(order, tipo);
        logger.info("AutoController.verTodosLosAutosEnStock(): " + autos.size());
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Auto>> verTodosLosAutosDisponibles() {
        List<Auto> autos = this.iAutoService.obtenerTodosLosAutos();
        logger.info("AutoController.verTodosLosAutosDisponibles(): " + autos.size());
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }

    @GetMapping(value = "/todos/{id}")
    public ResponseEntity<?> verAutoDisponible(@PathVariable(name = "id") Integer id) {
        Auto auto = null;
        try {
            auto = this.iAutoService.buscarAutoPorId(id);
            return new ResponseEntity<>(auto, HttpStatus.OK);
        } catch (AutoNotFoundException ex) {
            return new ResponseEntity<>(Response.notFound(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> verAutoDisponibleConStock(@PathVariable(name = "id") Integer id) {
        Auto auto = null;
        try {
            auto = this.iAutoService.buscarAutoConStockPorId(id);
            return new ResponseEntity<>(auto, HttpStatus.OK);
        } catch (AutoNotFoundException ex) {
            return new ResponseEntity<>(Response.notFound(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> crearAutoEnElStock(@RequestBody Auto auto) {
        try {
            Objects.requireNonNull(auto.getStock(), "not null");
            return new ResponseEntity<>(this.iAutoService.crearAuto(auto), HttpStatus.CREATED);
        } catch (AutoFoundException ex) {
            return new ResponseEntity<>(Response.error(ex), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException ex) {
            return new ResponseEntity<>(Response.error(ex), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarAutoDelStock(@PathVariable Integer id) {
        try {
            this.iAutoService.eliminarAuto(id);
            return new ResponseEntity<>(Response.ok("auto eliminado."), HttpStatus.OK);
        } catch (AutoNotFoundException ex) {
            return new ResponseEntity<>(Response.notFound(ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
