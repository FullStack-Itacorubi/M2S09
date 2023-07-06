package com.example.demo.repository;

import com.example.demo.dto.DadosBasicos;
import com.example.demo.entity.UsuarioEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    List<UsuarioEntity> findByStatus(Boolean status);

    List<UsuarioEntity> findByStatusOrNomeCompleto(Boolean status, String nomeCompleto);

    /*@Query(value = "select u.* from usuario u where u.idade >= 18", nativeQuery = true)
    List<UsuarioEntity> maiorIdade();*/


    @Query("Select u from UsuarioEntity u where u.idade >= 18")
    Optional<List<UsuarioEntity>> maiorIdade();

    @Query(value = "select u.nome_completo as nome, u.idade from usuario u", nativeQuery = true)
    List<DadosBasicos> getDadosBasicos();
}
