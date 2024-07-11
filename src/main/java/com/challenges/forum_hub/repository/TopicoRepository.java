package com.challenges.forum_hub.repository;

import com.challenges.forum_hub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}