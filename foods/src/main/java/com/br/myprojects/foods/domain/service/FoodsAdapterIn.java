package com.br.myprojects.foods.domain.service;

import com.br.myprojects.foods.application.dto.FoodsDTO;
import com.br.myprojects.foods.domain.entity.Foods;
import com.br.myprojects.foods.infraestructure.configuration.errors.ApiException;
import com.br.myprojects.foods.infraestructure.configuration.errors.CustomApiError;
import com.br.myprojects.foods.infraestructure.configuration.errors.HttpError;
import com.br.myprojects.foods.infraestructure.persistence.FoodsRepository;
import com.br.myprojects.foods.ports.inbound.FoodsPortIn;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodsAdapterIn implements FoodsPortIn {

    private final FoodsRepository repository;

    private final ModelMapper mapper;

    private final ObjectMapper objectMapper;

    @Override
    public FoodsDTO createNewFood(FoodsDTO foods) throws Exception {
        try {
            Foods foodCreate = mapper.map(foods, Foods.class);
            var optionalActivity = repository.save(foodCreate);
            return mapper.map(optionalActivity, FoodsDTO.class);
        }  catch (Exception e){
            throw new ApiException("Não foi possível criar novo alimento no banco de dados: " + e.getMessage(),
                    new CustomApiError(HttpError.INTERNAL_SERVER_ERROR, "/path/to/endpoint"));
        }
    }

    @Override
    public FoodsDTO getFoodsByName(String name) {
        return repository.findByDescricao(name)
                .map(entity -> mapper.map(entity, FoodsDTO.class))
                .orElse(null);
    }

    @Override
    public List<FoodsDTO> getAllFoods() {
        try {
            return repository.findAll().stream()
                    .map(foodies -> objectMapper.convertValue(foodies, FoodsDTO.class))
                    .toList();
        } catch (Exception e) {
            throw new ApiException("Não foi possível buscar a lista de alimentos no banco de dados: " + e.getMessage(),
                    new CustomApiError(HttpError.INTERNAL_SERVER_ERROR, "/path/to/endpoint"));
        }
    }
}
