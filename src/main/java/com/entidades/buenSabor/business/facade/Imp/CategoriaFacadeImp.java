package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.CategoriaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.domain.dto.categoria.CategoriaFullDto;
import com.entidades.buenSabor.domain.entities.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaFacadeImp extends BaseFacadeImp<Categoria, CategoriaFullDto, Long> implements CategoriaFacade {

    public CategoriaFacadeImp(BaseService<Categoria, Long> baseService, BaseMapper<Categoria, CategoriaFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
