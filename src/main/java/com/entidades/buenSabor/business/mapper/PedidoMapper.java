package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.pedido.PedidoFullDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { DomicilioMapper.class, SucursalMapper.class, DetallePedidoMapper.class })
public interface PedidoMapper extends BaseMapper<Pedido, PedidoFullDto>{
}
