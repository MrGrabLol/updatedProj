package com.hseproject.proj.service.Tag;

import com.hseproject.proj.model.Tag;
import com.hseproject.proj.repo.TagRepo;
import com.hseproject.proj.view.TagAddView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepo tagRepository;

    @Override
    public void add(TagAddView tag) {
        Tag t = new Tag(tag.name);
        tagRepository.save(t);
    }

    @Override
    public void edit(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void delete(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public Tag getById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tag> getAll() {
        return StreamSupport.stream(tagRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
