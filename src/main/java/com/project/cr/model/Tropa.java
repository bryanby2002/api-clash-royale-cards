package com.project.cr.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Tropa extends Carta {

    private String velocidad;
    private String velocidadAtaque;
    private Integer unidades;
    private String alcance;

}
