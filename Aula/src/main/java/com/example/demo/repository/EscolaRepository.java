package com.example.demo.repository;

import com.example.demo.dto.EscolaDto;
import com.example.demo.dto.ProfessorBasicoDto;
import com.example.demo.dto.ProfessorEscolaDto;
import com.example.demo.dto.RetornoEscolaDto;
import com.example.demo.entity.EscolaEntity;
import com.example.demo.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EscolaRepository extends JpaRepository<EscolaEntity, Long> {

    @Query("select new com.example.demo.dto.RetornoEscolaDto(e.id, e.nome, size(e.professores))" +
            "from EscolaEntity e")
    List<RetornoEscolaDto> getEscolasQtdProfessores();

    @Query("select new com.example.demo.dto.ProfessorBasicoDto(p) from ProfessorEntity p " +
            "join EscolaEntity e where e.id= :id and p member of e.professores")
    List<ProfessorBasicoDto> getProfessorPorEscolaId(Long id);

    @Query("select new com.example.demo.dto.EscolaDto(e) from EscolaEntity e " +
            "where e.id = :id")
    EscolaDto findByIdDto(Long id);

}
