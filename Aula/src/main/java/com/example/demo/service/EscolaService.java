package com.example.demo.service;

import com.example.demo.dto.EscolaDto;
import com.example.demo.dto.ProfessorBasicoDto;
import com.example.demo.dto.ProfessorDto;
import com.example.demo.dto.RetornoEscolaDto;
import com.example.demo.entity.AlunoEntity;
import com.example.demo.entity.EscolaEntity;
import com.example.demo.entity.ProfessorEntity;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {

    private EscolaRepository repository;
    private ProfessorRepository professorRepository;

    public EscolaService(EscolaRepository repository, ProfessorRepository professorRepository) {
        this.repository = repository;
        this.professorRepository = professorRepository;
    }

    public List<EscolaEntity> getAll() {
        return this.repository.findAll();
    }

    public EscolaDto getById(Long id) {
        return this.repository.findByIdDto(id);
        /*EscolaEntity escolaEntity = this.repository.findById(id);
        List<String> alunos = new ArrayList<>();
        List<String> professores = new ArrayList<>();

        for (AlunoEntity aluno: escolaEntity.getAlunos()) {
            alunos.add(aluno.getNome());
        }

        for (ProfessorEntity professor: escolaEntity.getProfessores()) {
            professores.add(professor.getNome());
        }

        return new EscolaDto(
                escolaEntity.getNome(),
                alunos,
                escolaEntity.getDiretor().getNome(),
                professores);*/
    }

    public ProfessorDto getProfessorEscolas(Long id) {
        ProfessorEntity professorEntity = this.professorRepository.findById(id).get();

        List<String> escolas = new ArrayList<>();

        for (EscolaEntity escola: professorEntity.getEscolas()) {
            escolas.add(escola.getNome());
        }

        return new ProfessorDto(professorEntity.getNome(), escolas);
    }


    public List<RetornoEscolaDto> getQtdProfessores() {
        return this.repository.getEscolasQtdProfessores();
    }

    public List<ProfessorBasicoDto> getProfessoresPorEscola(Long id) {
        return this.repository.getProfessorPorEscolaId(id);
    }
}
