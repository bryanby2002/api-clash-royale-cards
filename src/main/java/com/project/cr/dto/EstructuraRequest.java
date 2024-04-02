package com.project.cr.dto;

import com.project.cr.model.Carta;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
public class EstructuraRequest extends Carta {

    private String velocidadAtaque;
    private LocalTime tiempoDespliegue;
    private LocalTime tiempoVida;
}
