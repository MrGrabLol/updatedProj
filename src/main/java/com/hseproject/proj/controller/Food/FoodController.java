package com.hseproject.proj.controller.Food;

import com.hseproject.proj.model.Category;
import com.hseproject.proj.model.Food;
import com.hseproject.proj.service.Generator.GeneratorService;
import com.hseproject.proj.view.FoodAddView;
import com.hseproject.proj.view.GenerateView;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.hseproject.proj.service.Food.FoodService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class FoodController {

    final
    GeneratorService generatorService;

    final
    FoodService foodService;

    public FoodController(FoodService foodService, GeneratorService generatorService) {
        this.foodService = foodService;
        this.generatorService = generatorService;
    }

    @GetMapping("/food")
    public List<Food> getFood() {
        return foodService.getAll();
    }

    @PostMapping("/food")
    public void saveFood(@RequestBody FoodAddView foodAddView) {
        foodService.add(foodAddView);
    }

    @PostMapping("/recommend_meals")
    public List<Food> generate(@RequestBody GenerateView view) {
        return generatorService.generate(view);
    }

    @GetMapping("/meals")
    public List<Food> getMealsByCategory(@RequestBody Category category) {
        return foodService.getFoodByCategory(category);
    }

    @GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType(@PathVariable("id") String id) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/photo/" + id + ".png");
        return IOUtils.toByteArray(in);
    }
}
