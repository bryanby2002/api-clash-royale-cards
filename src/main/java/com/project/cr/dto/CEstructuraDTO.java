package com.project.cr.dto;

import com.project.cr.model.Carta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
public class CEstructuraDTO extends Carta {

    private String velocidadAtaque;
    private LocalTime tiempoDespliegue;
    private LocalTime tiempoVida;
}
