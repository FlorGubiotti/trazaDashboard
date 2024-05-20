package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.UsuarioEmpleadoFacadeImp;
import com.entidades.buenSabor.domain.dto.usuarioEmpleado.UsuarioEmpleadoFullDto;
import com.entidades.buenSabor.domain.entities.UsuarioEmpleado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarioEmpleado")
@CrossOrigin("*")
public class UsuarioEmpleadoController extends BaseControllerImp<UsuarioEmpleado, UsuarioEmpleadoFullDto, Long, UsuarioEmpleadoFacadeImp> {
    public UsuarioEmpleadoController(UsuarioEmpleadoFacadeImp facade) {super(facade); }

}