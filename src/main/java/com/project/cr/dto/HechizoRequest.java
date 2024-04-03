package com.project.cr.dto;

import com.project.cr.model.Carta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@AllArgsConstructor @NoArgsConstructor
public class HechizoRequest extends Carta {

    private Double radio;
    private LocalTime duracion;
}
