package com.example.demo.controller;

import com.example.demo.dto.EscolaDto;
import com.example.demo.dto.ProfessorBasicoDto;
import com.example.demo.dto.ProfessorDto;
import com.example.demo.dto.RetornoEscolaDto;
import com.example.demo.entity.EscolaEntity;
import com.example.demo.service.EscolaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/escola")
public class EscolaController {

    private EscolaService service;

    public EscolaController(EscolaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public EscolaDto getById(@PathVariable Long id) {
        return this.service.getById(id);
    }

    @GetMapping("/professor/{id}")
    public ProfessorDto getEscolasProfessor(@PathVariable Long id) {
        return this.service.getProfessorEscolas(id);
    }

    @GetMapping("/qtd-professores")
    public List<RetornoEscolaDto> getQtdProfessores() {
        return this.service.getQtdProfessores();
    }

    @GetMapping("/professor-escola/{id}")
    public List<ProfessorBasicoDto> getProfessorEscola(@PathVariable Long id) {
        return this.service.getProfessoresPorEscola(id);
    }
}
