package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.PromocionFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.promocion.PromocionFullDto;
import com.entidades.buenSabor.domain.entities.Promocion;
import org.springframework.stereotype.Service;

@Service
public class PromocionFacadeImp extends BaseFacadeImp<Promocion, PromocionFullDto, Long> implements PromocionFacade {
    public PromocionFacadeImp(BaseService<Promocion, Long> baseService, BaseMapper<Promocion, PromocionFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
