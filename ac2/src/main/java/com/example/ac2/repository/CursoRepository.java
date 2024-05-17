package com.example.ac2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac2.dtos.DadosProfessoresDTO;
import com.example.ac2.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    @Query("select cc from Curso cc left join fetch cc.professores where cc.id = :id")
    List<DadosProfessoresDTO> findCursoByIdFetchProfessores(@Param("id") Integer id);

}
