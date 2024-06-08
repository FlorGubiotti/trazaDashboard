package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.entities.*;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
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

    @Override
    public Pedido create(Pedido request) {
        // Validar que se haya pasado una sucursal en el body
        if (request.getSucursal() == null) {
            throw new RuntimeException("No se ha asignado una sucursal al pedido");
        }
        Sucursal sucursal = sucursalRepository.getById(request.getSucursal().getId());
        // Validar que la sucursal existe
        if (sucursal == null) {
            throw new RuntimeException("La sucursal con id " + request.getSucursal().getId() + " no se ha encontrado");
        }

        Set<DetallePedido> detalles = request.getDetallePedidos(); // Guardo los pedidoDetalle
        Set<DetallePedido> detallesPersistidos = new HashSet<>();

        if (detalles != null && !detalles.isEmpty()) {
            double costoTotal = 0;
            for (DetallePedido detalle : detalles) {
                // articulo del detalle
                Articulo articulo = detalle.getArticulo();
                if (articulo == null || articulo.getId() == null) {
                    throw new RuntimeException("El artículo del detalle no puede ser nulo.");
                }
                // Busco el articulo por id para verificar su existencia
                articulo = articuloRepository.findById(detalle.getArticulo().getId())
                        .orElseThrow(() -> new RuntimeException("Artículo con id " + detalle.getArticulo().getId() + " inexistente"));
                detalle.setArticulo(articulo);
                // Persistencia del detalle
                DetallePedido savedDetalle = detallePedidoRepository.save(detalle);
                costoTotal += calcularTotalCosto(articulo, detalle.getCantidad());
                // Descontar el stock
                descontarStock(articulo, detalle.getCantidad());

                detallesPersistidos.add(savedDetalle);
            }
            request.setTotalCosto(costoTotal); // Total costo pedido
            request.setDetallePedidos(detallesPersistidos); // Asignacion de detalles al pedido
        } else {
            throw new IllegalArgumentException("El pedido debe contener un detalle o mas.");
        }


        request.setSucursal(sucursal);

        request.setFechaPedido(LocalDate.now());

        return pedidoRepository.save(request); // Guardar el nuevo pedido
    }

    @Transactional
    public Articulo descontarStock(Articulo articulo, int cantidad) {
        if (articulo instanceof ArticuloInsumo) {

            ArticuloInsumo insumo = (ArticuloInsumo) articulo;
            System.out.println("Stock antes de descontar: " + insumo.getStockActual());
            int stockDescontado = insumo.getStockActual() - cantidad; // Descontar cantidad a stock actual
            System.out.println("Stock después de restarle la cantidad: " + stockDescontado);

            // Validar que el stock actual no supere el mínimo
            if (stockDescontado <= insumo.getStockMinimo()) {
                throw new RuntimeException("El insumo " + insumo.getDenominacion() + " alcanzó el stock mínimo: " + stockDescontado);
            }

            // Asignarle al insumo
            insumo.setStockActual(stockDescontado);
            return insumo; // Return the updated insumo

        } else if (articulo instanceof ArticuloManufacturado) {
            // Cast the articulo to ArticuloManufacturado
            ArticuloManufacturado manufacturado = (ArticuloManufacturado) articulo;
            // Obtener los detalles del manufacturado
            Set<ArticuloManufacturadoDetalle> detalles = manufacturado.getArticuloManufacturadoDetalles();

            if (detalles != null && !detalles.isEmpty()) {
                for (ArticuloManufacturadoDetalle detalle : detalles) {
                    ArticuloInsumo insumo = detalle.getArticuloInsumo();
                    // Cantidad necesaria de insumo por la cantidad de manufacturados del pedido
                    int cantidadInsumo = detalle.getCantidad() * cantidad;
                    // Descontar el stock actual
                    int stockDescontado = insumo.getStockActual() - cantidadInsumo;
                    if (stockDescontado <= insumo.getStockMinimo()) {
                        throw new RuntimeException("El insumo con id " + insumo.getId() + " (" + insumo.getDenominacion() + ") presente en el artículo "
                                + manufacturado.getDenominacion() + " (id " + manufacturado.getId() + ") alcanzó el stock mínimo: " + stockDescontado);
                    }
                    insumo.setStockActual(stockDescontado); // Asignarle al insumo, el stock descontado
                }
            }
            return manufacturado; // Return the updated manufacturado
        } else {
            // Por si no encuentra el artículo o es de un tipo desconocido
            throw new RuntimeException("Artículo de tipo desconocido con id " + articulo.getId());
        }
    }

    public Double calcularTotalCosto(Articulo articulo, Integer cantidad) {
        if (articulo instanceof ArticuloInsumo) { // verifico si es articuloInsumo
            ArticuloInsumo insumo = (ArticuloInsumo) articulo;
            return insumo.getPrecioCompra() * cantidad;
        } else if (articulo instanceof ArticuloManufacturado) { //verifico si es articuloManufacturado
            ArticuloManufacturado manufacturado = (ArticuloManufacturado) articulo;
            Set<ArticuloManufacturadoDetalle> detalles = manufacturado.getArticuloManufacturadoDetalles();

            if (detalles != null && !detalles.isEmpty()) {
                double totalCosto = 0;
                for (ArticuloManufacturadoDetalle detalle : detalles) {
                    double precioCompraInsumo = detalle.getArticuloInsumo().getPrecioCompra();
                    double cantidadInsumo = detalle.getCantidad();
                    totalCosto += (precioCompraInsumo * cantidadInsumo);
                }
                // Multiplicar por la cantidad de artículos manufacturados
                return totalCosto * cantidad;
            }
        }
        return 0.0;
    }
}
