package com.example.demo.controller;

import com.example.demo.dto.DadosBasicos;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioEntity> getAll() {
        return this.usuarioService.getAll();
    }

    // BUSCAR PELO ID
    @GetMapping("/{id}")
    public UsuarioEntity getById(@PathVariable Long id) {
        return this.usuarioService.getById(id);
    }

    @GetMapping("/ativo")
    public List<UsuarioEntity> getActive() {
        return this.usuarioService.getOnlyStatusTrue();
    }

    @GetMapping("/statusNome")
    public List<UsuarioEntity> getByStatusOuNome(@RequestParam Boolean status, @RequestParam String nome) {
        return this.usuarioService.getByStatusOrNome(status, nome);
    }

    @GetMapping("/maiorIdade")
    public List<UsuarioEntity> getMaiorIdade() throws Exception {
        return this.usuarioService.getMaiorIdade();
    }

    // SALVAR UM USUARIO
    @PostMapping
    public void save(@RequestBody UsuarioEntity usuario) {
        this.usuarioService.save(usuario);
    }

    // EXCLUIR UM USUÁRIO
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.usuarioService.delete(id);
    }

    @GetMapping("/basicos")
    public List<DadosBasicos> getDadosBasicos() {
        return this.usuarioService.getDadosBasicos();
    }


}
