package com.hseproject.proj.service.Generator;

import com.hseproject.proj.model.Food;
import com.hseproject.proj.view.GenerateView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GeneratorService {

    List<Food> generate(GenerateView view);

}
