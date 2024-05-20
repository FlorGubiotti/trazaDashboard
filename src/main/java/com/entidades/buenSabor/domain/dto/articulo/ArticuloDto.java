package com.entidades.buenSabor.domain.dto.articulo;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloDto extends BaseDto {
    protected String denominacion;
    protected Double precioVenta;
}
