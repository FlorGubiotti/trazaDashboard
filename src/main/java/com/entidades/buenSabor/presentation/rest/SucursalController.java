package com.entidades.buenSabor.presentation.rest;


import com.entidades.buenSabor.business.facade.Imp.SucursalFacadeImp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.domain.dto.sucursal.SucursalFullDto;

import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursal")
@CrossOrigin("*")
public class SucursalController extends BaseControllerImp<Sucursal, SucursalFullDto,Long, SucursalFacadeImp> {
    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImp.class);
    public SucursalController(SucursalFacadeImp facade) {
        super(facade);
    }

    @Override
    @PostMapping()
    public ResponseEntity<SucursalFullDto> create(@RequestBody SucursalFullDto dto) {
        return ResponseEntity.ok().body(facade.createSucursal(dto));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SucursalFullDto> edit(@RequestBody SucursalFullDto dto, @PathVariable Long id){
       logger.info("Editing Sucursal "+id);
       logger.info("Editing Sucursal "+dto.getId());
        return ResponseEntity.ok().body(facade.updateSucursal(id, dto));
    }

}
