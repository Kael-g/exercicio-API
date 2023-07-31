package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<LivroModel, Long> {
}
