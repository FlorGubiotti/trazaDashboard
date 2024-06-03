package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.UsuarioFacadeImp;
import com.entidades.buenSabor.domain.dto.usuarioCliente.UsuarioDto;
import com.entidades.buenSabor.domain.entities.Usuario;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarioCliente")
@CrossOrigin("*")
public class UsuarioController extends BaseControllerImp<Usuario, UsuarioDto, Long, UsuarioFacadeImp> {

    public UsuarioController(UsuarioFacadeImp facade) {super (facade); }

}
