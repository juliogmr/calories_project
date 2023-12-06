package com.br.myprojects.activities.application.dto;

import lombok.Data;

@Data
public class ActivityDTO {

    private Long id_exercicio;
    private String nome;
    private Double kcalPorMinuto;
}
