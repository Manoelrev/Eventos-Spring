package com.estudos.hellospring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Convidado {

    @Id
    @NotEmpty
    private String rg;
    @NotEmpty
    private String nome;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
}
