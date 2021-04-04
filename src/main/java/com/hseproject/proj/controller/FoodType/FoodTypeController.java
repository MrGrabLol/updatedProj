package com.hseproject.proj.controller.FoodType;

import com.hseproject.proj.service.FoodType.FoodTypeService;
import com.hseproject.proj.view.TypeAddView;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class FoodTypeController {

    final
    FoodTypeService foodTypeService;

    public FoodTypeController(FoodTypeService foodTypeService) {
        this.foodTypeService = foodTypeService;
    }

    @GetMapping()
    public void getFoodType() {
        foodTypeService.getAll();
    }

    @PostMapping()
    public void saveFoodType(@RequestBody TypeAddView typeAddView) {
        foodTypeService.add(typeAddView);
    }
}
