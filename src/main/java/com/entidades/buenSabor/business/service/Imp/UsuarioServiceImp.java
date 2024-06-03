package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.UsuarioService;
import com.entidades.buenSabor.domain.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp extends BaseServiceImp<Usuario, Long> implements UsuarioService {
}
