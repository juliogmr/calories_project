package com.br.myprojects.foods.application.dto;

import lombok.Data;

@Data
public class FoodsDTO {

    private Long id_alimento;
    private String descricao;
    private Double kcalPorG;
}
