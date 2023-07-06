package com.example.demo.dto;

import com.example.demo.entity.EscolaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProfessorDto {

    private String nome;

    private List<String> escolas;

}
