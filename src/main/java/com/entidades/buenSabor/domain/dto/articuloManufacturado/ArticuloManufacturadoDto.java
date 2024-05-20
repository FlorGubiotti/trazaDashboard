package com.entidades.buenSabor.domain.dto.articuloManufacturado;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDto extends BaseDto {
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
}
