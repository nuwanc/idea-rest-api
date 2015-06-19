package com.app.idea.service;

import com.app.idea.dto.IdeaDTO;
import com.app.idea.entity.Idea;
import com.app.idea.exception.IdeaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
final class IdeaJpaService implements IdeaService{

    private final IdeaRepository repository;

    @Autowired
    IdeaJpaService(IdeaRepository repository){
        this.repository = repository;
    }

    @Override
    public IdeaDTO create(IdeaDTO idea) {
        Idea persistence = new Idea();
        persistence.setTitle(idea.getTitle());
        persistence.setDescription(idea.getDescription());
        persistence.setCreatedAt(new Date());

        persistence = repository.saveAndFlush(persistence);

        return convertToDTO(persistence);
    }

    @Override
    public IdeaDTO delete(long id) {
        Idea idea = repository.findOne(id);
        repository.delete(idea);
        return convertToDTO(idea);
    }

    @Override
    public IdeaDTO update(IdeaDTO idea) {
        Idea update = repository.findOne(idea.getId());
        if (update != null){
            update.setTitle(idea.getTitle());
            update.setDescription(idea.getDescription());

            return convertToDTO(repository.saveAndFlush(update));
        } else {
            throw new IdeaNotFoundException(idea.getId());
        }

    }

    @Override
    public List<IdeaDTO> findAll() {
        List<Idea> ideas = repository.findAll();
        return convertToDTOs(ideas);
    }

    @Override
    public IdeaDTO findById(long id) {
        Idea idea = repository.findOne(id);
        if (idea != null){
            return convertToDTO(idea);
        } else {
            throw new IdeaNotFoundException(id);
        }

    }

    private IdeaDTO convertToDTO(Idea idea) {
        IdeaDTO ideaDto = new IdeaDTO();
        ideaDto.setDescription(idea.getDescription());
        ideaDto.setTitle(idea.getTitle());
        ideaDto.setCreatedAt(idea.getCreatedAt());
        ideaDto.setId(idea.getId());

        return ideaDto;
    }

    private List<IdeaDTO>convertToDTOs(List<Idea> ideas){
        return ideas.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
}
