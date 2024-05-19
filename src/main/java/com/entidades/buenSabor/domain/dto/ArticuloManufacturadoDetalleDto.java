package com.entidades.buenSabor.domain.dto;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalleDto extends BaseDto {
    private Integer cantidad;
    private Long articuloInsumoId;
}
