package com.hseproject.proj.controller.Tag;

import com.hseproject.proj.model.Tag;
import com.hseproject.proj.service.Tag.TagService;
import com.hseproject.proj.view.TagAddView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    final
    TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping()
    public List<Tag> getTag() {
        return tagService.getAll();
    }

    @PostMapping()
    public void saveTag(@RequestBody TagAddView tagAddView) {
        tagService.add(tagAddView);
    }
}
