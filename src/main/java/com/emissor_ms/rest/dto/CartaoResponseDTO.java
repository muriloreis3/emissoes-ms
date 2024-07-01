package com.emissor_ms.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartaoResponseDTO {
    private String nomeProposta;
    private BigDecimal limite;
    private String nomeCliente;
    private String emailCliente;
    private String numero;
    private String vencimento;
    private String emissao;
    private String cvv;
}
