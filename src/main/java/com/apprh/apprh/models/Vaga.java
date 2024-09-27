package com.apprh.apprh.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
public class Vaga implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private String data;

    @NotEmpty
    private String salario;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.REMOVE)
    private List<Candidato> candidatos;


}
