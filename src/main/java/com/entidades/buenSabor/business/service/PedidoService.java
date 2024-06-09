package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.repositories.PedidoRepository;

import java.time.Instant;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {

    List<Object[]> getRankingInsumo(Instant desde, Instant hasta);
    List<Object[]> getCantidadPedidosPorCliente(Instant desde, Instant hasta);
    List<Object[]> getIngresos(Instant desde, Instant hasta);
    List<Object[]> getGanancias(Instant desde, Instant hasta);

}
