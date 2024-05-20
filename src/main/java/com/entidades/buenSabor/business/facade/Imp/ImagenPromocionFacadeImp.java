package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.ImagenPromocionFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.imagen.ImagenPromocionFullDto;
import com.entidades.buenSabor.domain.entities.ImagenPromocion;
import org.springframework.stereotype.Service;

@Service
public class ImagenPromocionFacadeImp extends BaseFacadeImp<ImagenPromocion, ImagenPromocionFullDto, Long> implements ImagenPromocionFacade {

    public ImagenPromocionFacadeImp(BaseService<ImagenPromocion, Long> baseService, BaseMapper<ImagenPromocion, ImagenPromocionFullDto> baseMapper) {
        super(baseService, baseMapper);
    }

}
