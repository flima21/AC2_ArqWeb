package com.example.ac2.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
    @Query("SELECT ag FROM Agenda ag LEFT JOIN FETCH ag.professores WHERE ag.professores.id = :id")
    List<Agenda> findAgendaByIdProfessoresFetchProfessores(@Param("id") Integer professores_id);

    @Query("SELECT ag FROM Agenda ag inner JOIN FETCH ag.professores WHERE (ag.inicio >= :dataInicio and ag.fim <= :dataFinal) and (ag.professores.id = :id)")
    Agenda findAgendaFetchDataInicioProfessores(@Param("dataInicio") LocalDateTime dataInicio, @Param("dataFinal") LocalDateTime dataFinal, @Param("id") Integer id);

    boolean existsByProfessoresId(Integer id);
    boolean existsByCursosId(Integer id);

}
