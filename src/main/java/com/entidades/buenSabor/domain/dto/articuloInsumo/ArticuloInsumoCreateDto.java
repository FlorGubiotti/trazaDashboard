package com.entidades.buenSabor.domain.dto.articuloInsumo;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloInsumoCreateDto extends BaseDto {
    //de articulo
    private String denominacion;
    private String precioVenta;
    //propios de la clase
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esParaElaborar;
    //de unidadMedida
    private Long idUnidadMedida;
    //de categoria
    private Long idCategoria;
}
