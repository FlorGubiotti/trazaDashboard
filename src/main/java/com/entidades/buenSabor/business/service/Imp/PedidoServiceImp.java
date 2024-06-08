package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.entities.*;
import com.entidades.buenSabor.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PedidoServiceImp extends BaseServiceImp<Pedido, Long> implements PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    DetallePedidoRepository detallePedidoRepository;

    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    SucursalRepository sucursalRepository;

    @Autowired
    ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Override
    public Pedido create(Pedido request) {
        if (request.getSucursal() == null) {
            throw new RuntimeException("No se ha asignado una sucursal al pedido");
        }
        Sucursal sucursal = sucursalRepository.findById(request.getSucursal().getId())
                .orElseThrow(() -> new RuntimeException("La sucursal con id " + request.getSucursal().getId() + " no se ha encontrado"));

        // Guardar el pedido inicialmente sin los detalles
        request.setSucursal(sucursal);
        request.setFechaPedido(LocalDate.now());
        Pedido savedPedido = pedidoRepository.save(request);

        Set<DetallePedido> detalles = request.getDetallePedidos();
        if (detalles != null && !detalles.isEmpty()) {
            double costoTotal = 0;
            for (DetallePedido detalle : detalles) {
                Articulo articulo = detalle.getArticulo();
                if (articulo == null || articulo.getId() == null) {
                    throw new RuntimeException("El artículo del detalle no puede ser nulo.");
                }
                articulo = articuloRepository.findById(detalle.getArticulo().getId())
                        .orElseThrow(() -> new RuntimeException("Artículo con id " + detalle.getArticulo().getId() + " inexistente"));
                detalle.setArticulo(articulo);
                detalle.setPedido(savedPedido);  // Asignar el pedido guardado al detalle
                DetallePedido savedDetalle = detallePedidoRepository.save(detalle);
                costoTotal += calcularTotalCosto(articulo, detalle.getCantidad());
                descontarStock(articulo, detalle.getCantidad());
                savedPedido.getDetallePedidos().add(savedDetalle); // Modificar la colección existente
            }
            savedPedido.setTotalCosto(costoTotal);
        } else {
            throw new IllegalArgumentException("El pedido debe contener un detalle o más.");
        }

        return pedidoRepository.save(savedPedido);
    }

    @Transactional
    public Articulo descontarStock(Articulo articulo, int cantidad) {
        if (articulo instanceof ArticuloInsumo) {
            ArticuloInsumo insumo = (ArticuloInsumo) articulo;
            System.out.println("Stock antes de descontar: " + insumo.getStockActual());
            int stockDescontado = insumo.getStockActual() - cantidad;
            System.out.println("Stock después de restarle la cantidad: " + stockDescontado);

            if (stockDescontado <= insumo.getStockMinimo()) {
                throw new RuntimeException("El insumo " + insumo.getDenominacion() + " alcanzó el stock mínimo: " + stockDescontado);
            }

            insumo.setStockActual(stockDescontado);
            return insumo;

        } else if (articulo instanceof ArticuloManufacturado) {
            ArticuloManufacturado manufacturado = (ArticuloManufacturado) articulo;
            Set<ArticuloManufacturadoDetalle> detalles = manufacturado.getArticuloManufacturadoDetalles();

            if (detalles != null && !detalles.isEmpty()) {
                for (ArticuloManufacturadoDetalle detalle : detalles) {
                    ArticuloInsumo insumo = detalle.getArticuloInsumo();
                    int cantidadInsumo = detalle.getCantidad() * cantidad;
                    int stockDescontado = insumo.getStockActual() - cantidadInsumo;
                    if (stockDescontado <= insumo.getStockMinimo()) {
                        throw new RuntimeException("El insumo con id " + insumo.getId() + " (" + insumo.getDenominacion() + ") presente en el artículo "
                                + manufacturado.getDenominacion() + " (id " + manufacturado.getId() + ") alcanzó el stock mínimo: " + stockDescontado);
                    }
                    insumo.setStockActual(stockDescontado);
                }
            }
            return manufacturado;
        } else {
            throw new RuntimeException("Artículo de tipo desconocido con id " + articulo.getId());
        }
    }

    public Double calcularTotalCosto(Articulo articulo, Integer cantidad) {
        if (articulo instanceof ArticuloInsumo) {
            ArticuloInsumo insumo = (ArticuloInsumo) articulo;
            return insumo.getPrecioCompra() * cantidad;
        } else if (articulo instanceof ArticuloManufacturado) {
            ArticuloManufacturado manufacturado = (ArticuloManufacturado) articulo;
            Set<ArticuloManufacturadoDetalle> detalles = manufacturado.getArticuloManufacturadoDetalles();

            if (detalles != null && !detalles.isEmpty()) {
                double totalCosto = 0;
                for (ArticuloManufacturadoDetalle detalle : detalles) {
                    double precioCompraInsumo = detalle.getArticuloInsumo().getPrecioCompra();
                    double cantidadInsumo = detalle.getCantidad();
                    totalCosto += (precioCompraInsumo * cantidadInsumo);
                }
                return totalCosto * cantidad;
            }
        }
        return 0.0;
    }

    @Override
    public List<Object[]> getRankingInsumo(Instant desde, Instant hasta) {
        ZoneId zoneId = ZoneId.systemDefault();
        return pedidoRepository.getRankingInsumos(ZonedDateTime.ofInstant(desde, zoneId).toLocalDate(), ZonedDateTime.ofInstant(hasta, zoneId).toLocalDate());
    }
}
