package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.UsuarioFacadeImp;
import com.entidades.buenSabor.domain.dto.usuarioCliente.UsuarioDto;
import com.entidades.buenSabor.domain.entities.Usuario;
import com.entidades.buenSabor.domain.enums.Rol;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarioCliente")
@CrossOrigin("*")
public class UsuarioController extends BaseControllerImp<Usuario, UsuarioDto, Long, UsuarioFacadeImp> {

    public UsuarioController(UsuarioFacadeImp facade) {super (facade); }

    @GetMapping("role/{email}")
    @CrossOrigin("*")
    public Usuario getUsuarioPorEmail(@PathVariable String email) {
        return this.facade.obtenerUsuarioPorEmail(email);
    }

}
