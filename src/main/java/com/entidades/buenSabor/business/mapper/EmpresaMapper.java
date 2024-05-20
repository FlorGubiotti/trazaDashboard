package com.entidades.buenSabor.business.mapper;


import com.entidades.buenSabor.domain.dto.empresa.EmpresaDto;

import com.entidades.buenSabor.domain.dto.empresa.EmpresaLargeDto;
import com.entidades.buenSabor.domain.entities.Empresa;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper extends BaseMapper<Empresa, EmpresaDto> {


    EmpresaLargeDto toLargeDto(Empresa empresa);


}
