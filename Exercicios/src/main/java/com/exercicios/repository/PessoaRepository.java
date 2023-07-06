package com.exercicios.repository;

import com.exercicios.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

    List<PessoaEntity> findByStatus(boolean status);

    void deleteByStatus(boolean status);

//    @Query(value = "select * from pessoa where name like %:s% or email like %:s%", nativeQuery = true)
//    List<PessoaEntity> findAllFilter(String s);

    @Query("select p from PessoaEntity p where p.name like %?1% or p.email like %?1%")
    List<PessoaEntity> findAllFilter(String s);

}
