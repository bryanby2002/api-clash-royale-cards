package com.project.cr.service;

import com.project.cr.dto.CEstructuraDTO;
import com.project.cr.interfaces.IEstructura;
import com.project.cr.model.CEstructura;
import com.project.cr.repository.EstructuraRepo;
import org.springframework.stereotype.Service;

@Service
public class EstructuraService implements IEstructura {

    private final EstructuraRepo cEstructuraRepo;

    public EstructuraService(EstructuraRepo cEstructuraRepo){
        this.cEstructuraRepo = cEstructuraRepo;
    }

    @Override
    public CEstructura create(CEstructuraDTO cEstructuraDTO) {

        CEstructura estructura = new CEstructura();

        estructura.setNombre(cEstructuraDTO.getNombre());
        estructura.setDescripcion(cEstructuraDTO.getDescripcion());
        estructura.setTipo(cEstructuraDTO.getTipo());
        estructura.setCalidad(cEstructuraDTO.getCalidad());
        estructura.setObjetivo(cEstructuraDTO.getObjetivo());
        estructura.setCosteElixir(cEstructuraDTO.getCosteElixir());
        estructura.setVelocidadAtaque(cEstructuraDTO.getVelocidadAtaque());
        estructura.setTiempoDespliegue(cEstructuraDTO.getTiempoDespliegue());
        estructura.setTiempoVida(cEstructuraDTO.getTiempoVida());

        return this.cEstructuraRepo.save(estructura);
    }

}
