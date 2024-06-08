package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Articulo;
import com.entidades.buenSabor.domain.entities.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long>{

    @Query("SELECT dp.articulo, SUM(dp.cantidad)" +
            "FROM Pedido p " +
            "JOIN p.detallePedidos dp " +
            "WHERE p.fechaPedido BETWEEN :desde AND :hasta " +
            "GROUP BY dp.articulo")
    List<Object[]> getRankingInsumos(@Param("desde") LocalDate desde, @Param("hasta") LocalDate hasta);

    @Query("""
        SELECT c.email, COUNT(p) FROM Pedido p
        JOIN p.cliente c
        WHERE p.fechaPedido BETWEEN :desde AND :hasta
        GROUP BY c.id
    """)
    List<Object[]> getCantidadPedidosPorCliente(@Param("desde") LocalDate desde, @Param("hasta") LocalDate hasta);

}