package com.opendevpro.controller;

import com.opendevpro.component.AutoValidator;
import com.opendevpro.exception.AutosNotFoundException;
import com.opendevpro.model.Auto;
import com.opendevpro.service.interfaces.IAutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
//        logger.info("AutoController.verTodosLosAutosEnStock(): count -> " + autos.size());
        return ResponseEntity.ok(autos);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Auto>> verTodosLosAutosDisponibles() {
        List<Auto> autos = this.iAutoService.obtenerTodosLosAutos();
//        logger.info("AutoController.verTodosLosAutosDisponibles(): count -> " + autos.size());
        return ResponseEntity.ok(autos);
    }

    @GetMapping(value = "/todos/{id}")
    public ResponseEntity<Auto> verAutoDisponible(@PathVariable(name = "id") Integer id) {
        Auto auto = this.iAutoService.buscarAutoPorId(id);
        if (auto != null) {
            return ResponseEntity.ok(auto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Auto> verAutoDisponibleConStock(@PathVariable(name = "id") Integer id) {
        Auto autoBuscado = this.iAutoService.buscarAutoConStockPorId(id);
        if (autoBuscado != null) {
            logger.info("OK = AutoController.verTodosLosAutosDisponibles(): " + autoBuscado);
            return ResponseEntity.ok(autoBuscado);
        } else {
            logger.info("ERROR = AutoController.verTodosLosAutosDisponibles(): " + autoBuscado);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<String> crearAutoEnElStock(@RequestBody Auto auto, BindingResult bindingResult) {

        this.autoValidator.validate(auto, bindingResult);
        if (!bindingResult.hasErrors()) {
            Auto autoCreado = this.iAutoService.crearAuto(auto);
            logger.info("OK = AutoController.crearAutoEnElStock(): auto -> " + autoCreado);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Auto creado con exito.");
        } else {
            logger.error("ERROR =  AutoController.crearAutoEnElStock(): -> " + bindingResult.getFieldError());
            return ResponseEntity.badRequest()
                    .body("Error: " + bindingResult.getFieldError().getField());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarAutoDelStock(@PathVariable Integer id) {
        Auto autoBuscado = this.iAutoService.buscarAutoPorId(id);
        if (autoBuscado == null) {
            logger.error("ERROR =  AutoController.borrarAutoDelStock: -> " + autoBuscado);
            return ResponseEntity.notFound().build();
        }
        this.iAutoService.eliminarAuto(autoBuscado.getId());
        logger.info("OK =  AutoController.borrarAutoDelStock: -> " + autoBuscado.getId());
        return ResponseEntity.status(HttpStatus.OK).body("Borrado con exito.");
    }
}
