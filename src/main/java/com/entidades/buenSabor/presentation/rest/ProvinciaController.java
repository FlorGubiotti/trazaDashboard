package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ProvinciaFacadeImp;
import com.entidades.buenSabor.domain.dto.provincia.ProvinciaFullDto;
import com.entidades.buenSabor.domain.entities.Provincia;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provincia")
@CrossOrigin("*")
public class ProvinciaController extends BaseControllerImp<Provincia, ProvinciaFullDto,Long, ProvinciaFacadeImp>  {
    public ProvinciaController(ProvinciaFacadeImp facade) {
        super(facade);
    }

    private static final Logger logger = LoggerFactory.getLogger(ProvinciaController.class);

    @GetMapping("findByPais/{idPais}")
    public ResponseEntity<List<ProvinciaFullDto>> getByProvincia(@PathVariable Long idPais) {
        logger.info("INICIO GET BY PROVINCIA");
        return ResponseEntity.ok(facade.findByPaisId(idPais));
    }
}
