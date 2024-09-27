package com.apprh.apprh.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String rg;

    @NotEmpty(message = "O nome do candidato não pode ser vazio.")
    private String nomeCandidato;

    @NotEmpty(message = "O e-mail não pode ser vazio.")
    @Email(message = "O formato do e-mail é inválido.")
    private String email;

    @ManyToOne
    private Vaga vaga;

}
