package com.project.cr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "estructuras")
public class Estructura extends Carta {

    private String velocidadAtaque;
    private LocalTime tiempoDespliegue;
    private LocalTime tiempoVida;

}
