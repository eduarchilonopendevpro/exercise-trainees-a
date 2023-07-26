package com.opendevpro.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String home() {
        String text = "Hola mundo!";
        return text;
    }

    @GetMapping("/saludar")
    public String saludar() {
        String text = "Hola! Como estas?";
        return text;
    }

    @GetMapping("/saludar/{param}")
    public String saludarConParametros(
            @PathVariable(name = "param", required = false) String nombre) {
        String text = "Hola " + nombre + " Como estas?";
        return text;
    }

    @GetMapping("/datos") //cuando hay queryparam
    public String saludarConNombreYApellido(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "apellido") String apellido) {
        // http://localhost:8080/home/datos?nombre=eduar&apellido=chilon
        String text = "Hola " + nombre + " " + apellido + " Como estas?";
        return text;
    }
}
