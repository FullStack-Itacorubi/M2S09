package com.example.demo.dto;

import com.example.demo.entity.EscolaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ProfessorEscolaDto {

    List<ProfessorBasicoDto> basico;

    public ProfessorEscolaDto(EscolaEntity escola) {
        this.basico = new ArrayList<>();
       /* escola.getProfessores().forEach(p ->
                this.basico.add(new ProfessorBasicoDto(p.getId(), p.getNome()))
        );*/
    }

}
