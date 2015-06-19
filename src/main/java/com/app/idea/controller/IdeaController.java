package com.app.idea.controller;

import com.app.idea.dto.IdeaDTO;
import com.app.idea.entity.Idea;
import com.app.idea.exception.IdeaNotFoundException;
import com.app.idea.service.IdeaRepository;
import com.app.idea.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/ideas")
final class IdeaController {

    private final IdeaService service;

    @Autowired
    IdeaController(IdeaService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<IdeaDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public IdeaDTO add(@Validated @RequestBody IdeaDTO idea) {
        IdeaDTO model = new IdeaDTO();
        model.setCreatedAt(new Date());
        model.setTitle(idea.getTitle());
        model.setDescription(idea.getDescription());
        return service.create(model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public IdeaDTO findById(@PathVariable long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public IdeaDTO update(@PathVariable long id, @Validated @RequestBody IdeaDTO idea) {
        return service.update(idea);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public IdeaDTO delete(@PathVariable long id) {
        return service.delete(id);
    }



}
