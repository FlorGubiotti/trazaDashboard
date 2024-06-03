package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.UsuarioFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.usuarioCliente.UsuarioDto;
import com.entidades.buenSabor.domain.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioFacadeImp extends BaseFacadeImp<Usuario, UsuarioDto, Long> implements UsuarioFacade {


    public UsuarioFacadeImp(BaseService<Usuario, Long> baseService, BaseMapper<Usuario, UsuarioDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
