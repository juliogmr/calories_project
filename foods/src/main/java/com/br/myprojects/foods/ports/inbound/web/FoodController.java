package com.br.myprojects.foods.ports.inbound.web;

import com.br.myprojects.foods.application.dto.FoodsDTO;
import com.br.myprojects.foods.domain.entity.Foods;
import com.br.myprojects.foods.ports.inbound.FoodsPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodController {

    private final FoodsPortIn foodsPortIn;

    @GetMapping("/all")
    public ResponseEntity<List<FoodsDTO>> getAll(){
        return new ResponseEntity<>(foodsPortIn.getAllFoods(), HttpStatus.OK);
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<FoodsDTO> getByName(@PathVariable("name") String name) throws Exception {
        return new ResponseEntity<>(foodsPortIn.getFoodsByName(name), HttpStatus.OK);
    }
}
