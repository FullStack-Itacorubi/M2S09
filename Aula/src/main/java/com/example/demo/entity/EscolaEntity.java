package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "escola")
@Getter
@Setter
@Data
public class EscolaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "escola")
    private List<AlunoEntity> alunos;

    @OneToOne()
    @JoinColumn(name = "diretor_id", referencedColumnName = "id")
    private DiretorEntity diretor;

    @ManyToMany()
    @JoinTable(name = "escola_professor",
        joinColumns = @JoinColumn(name = "escola_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id", referencedColumnName = "id")
        )
    private List<ProfessorEntity> professores;

}
