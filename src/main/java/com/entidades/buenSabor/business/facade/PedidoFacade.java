package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.pedido.PedidoFullDto;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.time.Instant;
import java.util.List;

public interface PedidoFacade extends BaseFacade<PedidoFullDto, Long> {

    SXSSFWorkbook getRankingInsumo(Instant desde, Instant hasta);

    SXSSFWorkbook getCantidadDePedidosPorCliente(Instant desde, Instant hasta);

}
