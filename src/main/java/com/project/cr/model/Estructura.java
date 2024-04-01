package com.project.cr.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estructura extends Carta {

    private String velocidadAtaque;
    private LocalTime tiempoDespliegue;
    private LocalTime tiempoVida;

}
