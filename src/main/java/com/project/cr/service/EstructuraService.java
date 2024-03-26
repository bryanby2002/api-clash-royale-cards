package com.project.cr.service;

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
    public CEstructura create(CEstructura cEstructura) {
        return cEstructuraRepo.save(cEstructura);

    }


}
