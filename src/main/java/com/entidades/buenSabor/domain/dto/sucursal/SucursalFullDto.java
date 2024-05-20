package com.entidades.buenSabor.domain.dto.sucursal;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.domicilio.DomicilioFullDto;
import com.entidades.buenSabor.domain.dto.empresa.EmpresaCreateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SucursalFullDto extends BaseDto {

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean esCasaMatriz;

    private DomicilioFullDto domicilio;
    private EmpresaCreateDto empresa;
}