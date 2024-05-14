package com.example.ac2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac2.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
