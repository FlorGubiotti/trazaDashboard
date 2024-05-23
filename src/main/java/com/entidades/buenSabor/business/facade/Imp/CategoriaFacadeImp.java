package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.CategoriaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.domain.dto.categoria.CategoriaCreateDto;
import com.entidades.buenSabor.domain.dto.categoria.CategoriaFullDto;
import com.entidades.buenSabor.domain.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaFacadeImp extends BaseFacadeImp<Categoria, CategoriaFullDto, Long> implements CategoriaFacade {

    public CategoriaFacadeImp(BaseService<Categoria, Long> baseService, BaseMapper<Categoria, CategoriaFullDto> baseMapper) {
        super(baseService, baseMapper);
    }
    @Autowired
    private CategoriaService categoriaService;

    @Override
    public CategoriaFullDto addInsumo(Long idCategoria, Long idInsumo) {
        return baseMapper.toDTO(categoriaService.addArticulo(idCategoria,idInsumo));
    }

    @Override
    public CategoriaFullDto addManufacturado(Long idCategoria, Long idManufacturado) {
        return baseMapper.toDTO(categoriaService.addArticulo(idCategoria,idManufacturado));
    }

    @Override
    public CategoriaFullDto addSubCategoria(Long idCategoria, CategoriaFullDto subCategoria) {
        Categoria subCategoriaToCreate = baseMapper.toEntityCreate(subCategoria);
        return baseMapper.toDTO(categoriaService.addSubCategoria(idCategoria, subCategoriaToCreate));
    }
}
