package com.example.demo.dto;

import com.example.demo.entity.AlunoEntity;
import com.example.demo.entity.EscolaEntity;
import com.example.demo.entity.ProfessorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EscolaDto {

    private String nome;

    private List<String> alunos;

    private String diretor;

    private List<String> professores;

    public EscolaDto (EscolaEntity e) {
        this.nome = e.getNome();
        this.diretor = e.getDiretor().getNome();
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();

        for (ProfessorEntity professor : e.getProfessores()) {
            this.professores.add(professor.getNome());
        }

        for (AlunoEntity aluno : e.getAlunos()) {
            this.alunos.add(aluno.getNome());
        }
    }

}
