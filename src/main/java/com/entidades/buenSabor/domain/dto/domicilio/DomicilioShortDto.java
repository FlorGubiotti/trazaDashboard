package com.entidades.buenSabor.domain.dto.domicilio;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DomicilioShortDto extends BaseDto {
    private String calle;
    private Integer cp;
}
