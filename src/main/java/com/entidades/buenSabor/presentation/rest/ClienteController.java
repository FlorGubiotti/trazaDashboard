package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ClienteFacadeImp;
import com.entidades.buenSabor.domain.dto.cliente.ClienteFullDto;
import com.entidades.buenSabor.domain.entities.Cliente;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController extends BaseControllerImp<Cliente, ClienteFullDto, Long, ClienteFacadeImp> {

    public ClienteController(ClienteFacadeImp facade) {super (facade); }
}
