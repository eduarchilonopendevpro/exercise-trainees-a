package com.opendevpro.service;

import com.opendevpro.exception.AutoNotFoundException;
import com.opendevpro.model.Auto;
import com.opendevpro.model.Venta;
import com.opendevpro.repository.IAutoRepository;
import com.opendevpro.repository.IVentaRepository;
import com.opendevpro.service.interfaces.IAutoService;
import com.opendevpro.service.interfaces.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {

    private IAutoRepository iAutoRepository;
    private IVentaRepository iVentaRepository;
    private IAutoService iAutoService;

    @Autowired
    public VentaService(IAutoRepository iAutoRepository, IVentaRepository iVentaRepository, IAutoService iAutoService){
        this.iAutoRepository = iAutoRepository;
        this.iVentaRepository = iVentaRepository;
        this.iAutoService = iAutoService;
    }

    @Override
    public Venta createVenta(Venta venta) throws AutoNotFoundException {
        Optional<Auto> autoAComprar = this.iAutoRepository.findById(venta.getAutoId());
        if (!autoAComprar.isPresent()){
//            throw new AutosNotFoundException("No existe auto con el id: " + venta.getAutoId());
        }
        this.iAutoService.descontarStockDelAuto(autoAComprar.get().getId(), venta.getCantidad());
        return this.iVentaRepository.save(venta);
    }

    @Override
    public List<Venta> obtenerTodasLasVentas() {
        return this.iVentaRepository.findAll();
    }
}
