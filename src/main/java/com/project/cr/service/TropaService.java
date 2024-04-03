package com.project.cr.service;

import com.project.cr.dto.TropaRequest;
import com.project.cr.interfaces.ITropa;
import com.project.cr.model.Tropa;
import com.project.cr.repository.TropaRepo;
import org.springframework.stereotype.Service;

@Service
public class TropaService implements ITropa {

    private final TropaRepo cTropaRepo;

    public TropaService(TropaRepo cTropaRepo){
        this.cTropaRepo = cTropaRepo;
    }

    @Override
    public void save(TropaRequest tropaRequest) {

        Tropa tropa = new Tropa();

        tropa.setNombre(tropaRequest.getNombre());
        tropa.setDescripcion(tropaRequest.getDescripcion());
        tropa.setTipo(tropaRequest.getTipo());
        tropa.setCalidad(tropaRequest.getCalidad());
        tropa.setObjetivo(tropaRequest.getObjetivo());
        tropa.setCosteElixir(tropaRequest.getCosteElixir());
        tropa.setVelocidad(tropaRequest.getVelocidad());
        tropa.setVelocidadAtaque(tropaRequest.getVelocidadAtaque());
        tropa.setUnidades(tropaRequest.getUnidades());
        tropa.setAlcance(tropaRequest.getAlcance());

        cTropaRepo.save(tropa);

    }


}
