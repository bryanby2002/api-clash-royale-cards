package com.project.cr.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class CTropa extends Carta {

    private String velocidad;
    private String velocidadAtaque;
    private Integer unidades;
    private String alcance;

}
