package com.example.ac2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    @Query("SELECT p FROM Professores p RIGHT JOIN FETCH p.agenda WHERE p.id = :id")
    List<Professor> findProfessoresFetchAgenda(@Param("id") Integer id);

}
