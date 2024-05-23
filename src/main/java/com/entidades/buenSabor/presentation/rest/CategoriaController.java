package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.CategoriaFacadeImp;
import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.domain.dto.categoria.CategoriaCreateDto;
import com.entidades.buenSabor.domain.dto.categoria.CategoriaFullDto;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.presentation.rest.Base.BaseController;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController extends BaseControllerImp<Categoria, CategoriaCreateDto, Long, CategoriaFacadeImp> {

    public CategoriaController(CategoriaFacadeImp facade) {super (facade); }
    @Autowired
    private CategoriaService categoriaService;

    @PutMapping("/addInsumo/{idCategoria}/{idInsumo}")
    public ResponseEntity<CategoriaFullDto> addArticuloInsumo(@PathVariable Long idCategoria, @PathVariable Long idInsumo){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.addInsumo(idCategoria,idInsumo));
    }

    @PutMapping("/addArticuloManufacturado/{idCategoria}/{idArticulo}")
    public ResponseEntity<CategoriaFullDto> addArticuloManufacturado(@PathVariable Long idCategoria, @PathVariable Long idArticulo){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.addInsumo(idCategoria,idArticulo));
    }

}
