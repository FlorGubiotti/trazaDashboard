package com.entidades.buenSabor.domain.dto.articuloManufacturadoDetalle;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalleDto extends BaseDto {
    private Integer cantidad;
    private Long articuloInsumoId;
}
