package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.PedidoFacadeImp;
import com.entidades.buenSabor.domain.dto.pedido.PedidoFullDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;

@RestController
@RequestMapping("/pedido")
@CrossOrigin("*")
public class PedidoController extends BaseControllerImp<Pedido, PedidoFullDto, Long, PedidoFacadeImp> {

    public PedidoController(PedidoFacadeImp facade) {super (facade); }

    @GetMapping("ranking/insumos/excel")
    public ResponseEntity<byte[]> downloadRankingInsumosExcel(@RequestParam("desde") Instant desde, @RequestParam("hasta") Instant hasta) throws SQLException {
        try {
            SXSSFWorkbook libroExcel = this.facade.getRankingInsumo(desde, hasta);
            // Escribir el libro de trabajo en un flujo de bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            libroExcel.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "datos.xlsx");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("ranking/pedidos/cliente/excel")
    public ResponseEntity<byte[]> downloadCantidadPedidosPorClienteExcel(@RequestParam("desde") Instant desde, @RequestParam("hasta") Instant hasta) throws SQLException {
        try {
            SXSSFWorkbook libroExcel = this.facade.getCantidadDePedidosPorCliente(desde, hasta);
            // Escribir el libro de trabajo en un flujo de bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            libroExcel.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "datos.xlsx");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("ranking/ingresos/excel")
    public ResponseEntity<byte[]> downloadIngresosExcel(@RequestParam("desde") Instant desde, @RequestParam("hasta") Instant hasta) throws SQLException {
        try {
            SXSSFWorkbook libroExcel = this.facade.getIngresos(desde, hasta);
            // Escribir el libro de trabajo en un flujo de bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            libroExcel.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "datos.xlsx");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("ranking/ganancias/excel")
    public ResponseEntity<byte[]> downloadGananciasExcel(@RequestParam("desde") Instant desde, @RequestParam("hasta") Instant hasta) throws SQLException {
        try {
            SXSSFWorkbook libroExcel = this.facade.getGanancias(desde, hasta);
            // Escribir el libro de trabajo en un flujo de bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            libroExcel.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "datos.xlsx");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{pedidoId}/estado")
    public ResponseEntity<Pedido> cambiarEstadoPedido(
            @PathVariable Long pedidoId,
            @RequestParam Estado nuevoEstado
    ) {
        Pedido pedidoActualizado = this.facade.cambiarEstado(pedidoId, nuevoEstado);
        return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
    }

}
