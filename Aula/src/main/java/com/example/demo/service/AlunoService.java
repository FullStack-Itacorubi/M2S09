package com.example.demo.service;

import com.example.demo.entity.AlunoEntity;
import com.example.demo.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<AlunoEntity> getAlunos() {
        return this.repository.findAll();
    }

}
