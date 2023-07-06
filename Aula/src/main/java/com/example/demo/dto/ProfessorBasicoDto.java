package com.example.demo.dto;

import com.example.demo.entity.EscolaEntity;
import com.example.demo.entity.ProfessorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfessorBasicoDto {

    private Long id;
    private String nome;

    public ProfessorBasicoDto(ProfessorEntity professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
    }

}
