package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PreferenceMP implements Serializable {
    @Id
    private String id;
    private Long idPedido;
    private int statusCode;
    private OffsetDateTime fechaCreacion;
    private OffsetDateTime fechaExpiracion;
    private BigDecimal total;
    private String payerEmail;
    private String payerName;
    private String payerSurname;
    private String paymentMethods;
}
