package com.br.myprojects.activities.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXERCICIOS")
public class Activities {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXERCICIOS_SEQ")
    @SequenceGenerator(name = "EXERCICIOS_SEQ", sequenceName = "EXERCICIOS_SEQ", allocationSize = 1)
    @Column(name = "ID_EXERCICIO")
    private Long id_exercicio;

    @Column(name = "DESCRICAO", nullable = false)
    private String nome;

    @Column(name = "KCAL_POR_MIN", nullable = false)
    private Double kcalPorMinuto;
}
