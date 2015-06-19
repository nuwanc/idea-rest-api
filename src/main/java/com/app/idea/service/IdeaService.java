package com.app.idea.service;

import com.app.idea.dto.IdeaDTO;

import java.util.List;

public interface IdeaService {

    IdeaDTO create(IdeaDTO idea);

    IdeaDTO delete(long id);

    IdeaDTO update(IdeaDTO idea);

    List<IdeaDTO> findAll();

    IdeaDTO findById(long id);

}
