package com.opendevpro.service;

import com.opendevpro.exception.AutosNotFoundException;
import com.opendevpro.model.Auto;
import com.opendevpro.repository.IAutoRepository;
import com.opendevpro.service.interfaces.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutoService implements IAutoService {

    @Autowired
    private IAutoRepository iAutoRepository;

    public AutoService(IAutoRepository iAutoRepository) {
        this.iAutoRepository = iAutoRepository;
    }

    @Override
    public Auto crearAuto(Auto auto) {
        return this.iAutoRepository.save(auto);
    }

    @Override
    public Auto buscarAutoPorId(Integer id) {
        return this.iAutoRepository.findById(id).orElse(null);
    }

    @Override
    public Auto buscarAutoConStockPorId(Integer id) {
        List<Auto> autos = this.iAutoRepository.findAll();
        Auto autoBUscado = null;
        for (Auto a : autos) {
            if (a.getStock() > 0 && a.getId().equals(id)) {
                autoBUscado = a;
            }
        }
        return autoBUscado;
    }

    @Override
    public List<Auto> obtenerTodosLosAutos() {
        return this.iAutoRepository.findAll();
    }

    @Override
    public List<Auto> obtenerTodosLosAutosConStock() {
        List<Auto> autosDisponibles = this.iAutoRepository.findAll()
                .stream().filter((a) -> a.getStock() > 0)
                .collect(Collectors.toList());
        return autosDisponibles;
    }

    @Override
    public List<Auto> obtenerTodosLosAutosConStock(String order, String tipo) {
        List<Auto> autosDisponibles = new ArrayList<>();
        if (order != null && order.toUpperCase().equals("ASC")) {
            if (tipo != null && tipo.toUpperCase().equals("ORM")){
                autosDisponibles = this.iAutoRepository.ordernarPorORMASC();
            }else{
                autosDisponibles = this.obtenerTodosLosAutosConStock()
                        .stream().sorted((x, y) -> x.getBrand().compareTo(y.getBrand())).collect(Collectors.toList());
            }
        } else if (order != null && order.toUpperCase().equals("DSC")) {
            if (tipo != null && tipo.toUpperCase().equals("ORM")){
                autosDisponibles = this.iAutoRepository.ordernarPorORMDESC();
            }else{
                autosDisponibles = this.obtenerTodosLosAutosConStock()
                        .stream().sorted((x, y) -> y.getBrand().compareTo(x.getBrand())).collect(Collectors.toList());
            }
        } else {
            autosDisponibles = this.iAutoRepository.findAll()
                    .stream().filter((a) -> a.getStock() > 0)
                    .collect(Collectors.toList());;
        }
        return autosDisponibles;
    }

    @Override
    public void eliminarAuto(Integer id) {
        this.iAutoRepository.deleteById(id);
    }

    @Override
    public Auto descontarStockDelAuto(Integer id, Integer stock) {
        Optional<Auto> autoEncontrado = null;
        if (this.iAutoRepository.existsById(id)) {
            autoEncontrado = this.iAutoRepository.findById(id);
        }

        Integer nuevoStock = autoEncontrado.get().getStock();
        if (stock < nuevoStock) {
            nuevoStock = nuevoStock - stock;
            autoEncontrado.get().setStock(nuevoStock);
            this.iAutoRepository.save(autoEncontrado.get());
        }
        return autoEncontrado.get();
    }

    @Override
    public Auto modificarStockDelAutoDisponible(Integer id, Integer stock) {
        Optional<Auto> autoEncontrado = this.iAutoRepository.findById(id);
        System.out.println(autoEncontrado.get());
        if (this.iAutoRepository.existsById(id)) {
            autoEncontrado.get().setStock(stock);
            this.iAutoRepository.save(autoEncontrado.get());
        }
        return autoEncontrado.get();
    }
}
