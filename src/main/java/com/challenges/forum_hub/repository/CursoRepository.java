package com.challenges.forum_hub.repository;

import com.challenges.forum_hub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}