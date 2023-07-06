package com.example.demo.service;

import com.example.demo.dto.DadosBasicos;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioEntity> getAll() {
        return this.repository.findAll();
    }

    public UsuarioEntity getById(Long id) {
        Optional<UsuarioEntity> opUsuario = this.repository.findById(id);
        if (opUsuario.isPresent()) {
            return opUsuario.get();
        }
        return null;
    }

    public void save(UsuarioEntity usuario) {
        this.repository.save(usuario);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<UsuarioEntity> getOnlyStatusTrue() {
        return this.repository.findByStatus(true);
    }

    public List<UsuarioEntity> getByStatusOrNome(Boolean status, String nome) {
        return this.repository.findByStatusOrNomeCompleto(status, nome);
    }

    public List<UsuarioEntity> getMaiorIdade() throws Exception {
        Optional<List<UsuarioEntity>> usuarioEntities = this.repository.maiorIdade();
        if (usuarioEntities.get().isEmpty()) {
            throw new Exception("NÃO TEM NINGUEM MAIOR DE IDADE!");
        }

        return usuarioEntities.get();
    }

    public List<DadosBasicos> getDadosBasicos() {
        return this.repository.getDadosBasicos();
    }


}
