package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.EmpresaFacadeImpl;

import com.entidades.buenSabor.domain.dto.empresa.EmpresaCreateDto;

import com.entidades.buenSabor.domain.dto.empresa.EmpresaFullDto;
import com.entidades.buenSabor.domain.entities.Empresa;

import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("*")
public class EmpresaController extends BaseControllerImp<Empresa, EmpresaCreateDto, Long, EmpresaFacadeImpl> {
    public EmpresaController(EmpresaFacadeImpl facade) {
        super(facade);
    }

    @PutMapping("/addSucursal/{idEmpresa}/{idSucursal}")
    public ResponseEntity<EmpresaFullDto> addSucursal(Long idEmpresa, Long idSucursal){
        return ResponseEntity.ok(facade.addSucursal(idEmpresa,idSucursal));
    }
}
