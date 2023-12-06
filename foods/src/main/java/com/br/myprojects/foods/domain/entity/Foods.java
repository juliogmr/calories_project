package com.br.myprojects.foods.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALIMENTOS")
public class Foods {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALIMENTOS_SEQ")
    @SequenceGenerator(name = "ALIMENTOS_SEQ", sequenceName = "ALIMENTOS_SEQ", allocationSize = 1)
    @Column(name = "ID_ALIMENTO")
    private Long id_alimento;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "KCAL_POR_100G", nullable = false)
    private Double kcalPorG;
}
