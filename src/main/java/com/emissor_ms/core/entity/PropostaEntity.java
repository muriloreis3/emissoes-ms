package com.emissor_ms.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proposta")
public class PropostaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomeProposta")
    private String nomeProposta;

    @Column(name = "limite")
    private BigDecimal limite;

    @ManyToOne
    @JoinColumn(name = "contaId")
    private ContaEntity conta;
}
