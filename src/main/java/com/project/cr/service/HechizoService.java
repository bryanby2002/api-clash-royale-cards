package com.project.cr.service;

import com.project.cr.dto.HechizoRequest;
import com.project.cr.interfaces.IHechizo;
import com.project.cr.model.Hechizo;
import com.project.cr.repository.HechizoRepo;
import org.springframework.stereotype.Service;

@Service
public class HechizoService implements IHechizo {

    private final HechizoRepo hechizoRepo;

    public HechizoService(HechizoRepo hechizoRepo){
        this.hechizoRepo = hechizoRepo;
    }

    @Override
    public void save(HechizoRequest hechizoRequest) {

        Hechizo hechizo = new Hechizo();

        hechizo.setNombre(hechizoRequest.getNombre());
        hechizo.setDescripcion(hechizoRequest.getDescripcion());
        hechizo.setTipo(hechizoRequest.getTipo());
        hechizo.setCalidad(hechizoRequest.getCalidad());
        hechizo.setObjetivo(hechizoRequest.getObjetivo());
        hechizo.setCosteElixir(hechizoRequest.getCosteElixir());
        hechizo.setRadio(hechizoRequest.getRadio());
        hechizo.setDuracion(hechizoRequest.getDuracion());

        hechizoRepo.save(hechizo);

    }


}
