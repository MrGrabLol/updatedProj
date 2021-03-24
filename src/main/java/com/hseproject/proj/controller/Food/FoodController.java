package com.hseproject.proj.controller.Food;

import com.hseproject.proj.model.Food;
import com.hseproject.proj.service.Generator.GeneratorService;
import com.hseproject.proj.view.FoodAddView;
import com.hseproject.proj.view.GenerateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hseproject.proj.service.Food.FoodService;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    GeneratorService generatorService;

    final
    FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/food")
    public List<Food> getFood() {
        return foodService.getAll();
    }

    @PostMapping("/food")
    public void saveFood(@RequestBody FoodAddView foodAddView) {
        foodService.add(foodAddView);
    }

    @PostMapping("/generate")
    public List<Food> generate(@RequestBody GenerateView view) {
        return generatorService.generate(view);
    }
}
