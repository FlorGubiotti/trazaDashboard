package com.entidades.buenSabor.domain.dto.cliente;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteFullDto extends BaseDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

}
