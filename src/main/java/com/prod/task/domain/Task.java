package com.prod.task.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TASK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOME", unique = true)
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "SALDO_NECESSARIO", nullable = false)
    private double saldoNecessario;

    @Column(name = "SALDO_ATUAL")
    private Double saldoAtual;

    @Column(name = "CRIADA_EM")
    @CreationTimestamp
    private LocalDateTime criadaEm;

    @Column(name = "MODIFICADA_EM")
    @UpdateTimestamp
    private LocalDateTime modificadaEm;
}
