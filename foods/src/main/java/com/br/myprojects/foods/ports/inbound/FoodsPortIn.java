package com.br.myprojects.foods.ports.inbound;

import com.br.myprojects.foods.application.dto.FoodsDTO;
import com.br.myprojects.foods.domain.entity.Foods;

import java.util.List;

public interface FoodsPortIn {

    public FoodsDTO createNewFood(FoodsDTO foods) throws Exception;

    public FoodsDTO getFoodsByName(String name) throws Exception;

    public List<FoodsDTO> getAllFoods();
}
