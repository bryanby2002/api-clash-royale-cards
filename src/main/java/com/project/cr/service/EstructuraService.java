package com.project.cr.service;

import com.project.cr.dto.EstructuraRequest;
import com.project.cr.interfaces.IEstructura;
import com.project.cr.model.Estructura;
import com.project.cr.repository.EstructuraRepo;
import org.springframework.stereotype.Service;

@Service
public class EstructuraService implements IEstructura {

    private final EstructuraRepo cEstructuraRepo;

    public EstructuraService(EstructuraRepo cEstructuraRepo){
        this.cEstructuraRepo = cEstructuraRepo;
    }

    @Override
    public void save(EstructuraRequest estructuraRequest) {

        Estructura estructura = new Estructura();

        estructura.setNombre(estructuraRequest.getNombre());
        estructura.setDescripcion(estructuraRequest.getDescripcion());
        estructura.setTipo(estructuraRequest.getTipo());
        estructura.setCalidad(estructuraRequest.getCalidad());
        estructura.setObjetivo(estructuraRequest.getObjetivo());
        estructura.setCosteElixir(estructuraRequest.getCosteElixir());
        estructura.setVelocidadAtaque(estructuraRequest.getVelocidadAtaque());
        estructura.setTiempoDespliegue(estructuraRequest.getTiempoDespliegue());
        estructura.setTiempoVida(estructuraRequest.getTiempoVida());

        cEstructuraRepo.save(estructura);

    }

}
