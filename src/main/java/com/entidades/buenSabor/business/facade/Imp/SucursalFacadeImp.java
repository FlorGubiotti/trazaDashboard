package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.Sucursalfacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.dto.sucursal.SucursalFullDto;
import com.entidades.buenSabor.domain.entities.Sucursal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalFacadeImp extends BaseFacadeImp<Sucursal, SucursalFullDto,Long> implements Sucursalfacade {
    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImp.class);
    @Autowired
    SucursalService sucursalService;
    public SucursalFacadeImp(BaseService<Sucursal, Long> baseService, BaseMapper<Sucursal, SucursalFullDto> baseMapper) {
        super(baseService, baseMapper);
    }


    @Override
    public SucursalFullDto createSucursal(SucursalFullDto dto) {
        var sucursal=baseMapper.toEntity(dto);
        var sucursalPersistida=sucursalService.guardarSucursal(sucursal);
        return baseMapper.toDTO(sucursalPersistida);
    }

    @Override
    public SucursalFullDto updateSucursal(Long id, SucursalFullDto dto) {

        var sucursal=baseMapper.toEntity(dto);

        var sucursalActualizada=sucursalService.actualizarSucursal(id,sucursal);
        return baseMapper.toDTO(sucursalActualizada);
    }
}
