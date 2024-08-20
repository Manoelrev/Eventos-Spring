package com.estudos.hellospring.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Evento implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String nome;
    @NotEmpty
    private String localizacao;
    @NotEmpty
    private String datalocal;
    @NotEmpty
    private String horario;

    public Evento(String nome, String local, String data, String horario) {
        this.nome = nome;
        this.localizacao = local;
        this.datalocal = data;
        this.horario = horario;
    }
}
