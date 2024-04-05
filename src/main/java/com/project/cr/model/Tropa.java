package com.project.cr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "tropas")
public class Tropa extends Carta {

    private String velocidad;
    private String velocidadAtaque;
    private Integer unidades;
    private String alcance;

}
