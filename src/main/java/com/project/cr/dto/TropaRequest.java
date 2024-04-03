package com.project.cr.dto;

import com.project.cr.model.Carta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TropaRequest extends Carta {

    private String velocidad;
    private String velocidadAtaque;
    private Integer unidades;
    private String alcance;

}
