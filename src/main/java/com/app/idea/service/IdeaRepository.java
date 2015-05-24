package com.app.idea.service;


import com.app.idea.entity.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaRepository extends JpaRepository<Idea,Long>{

}
