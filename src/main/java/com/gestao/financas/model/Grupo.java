package com.gestao.financas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @ManyToOne
    private Pessoa pessoa;
    private Boolean isSaldoNegativo;

    @OneToOne(fetch = FetchType.EAGER)
    private Meta meta;


    public Grupo() {
    }


    public Grupo(Long id, String nome, String descricao, Meta meta) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.meta = meta;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Boolean getSaldoNegativo() {
        return isSaldoNegativo;
    }

    public void setSaldoNegativo(Boolean saldoNegativo) {
        isSaldoNegativo = saldoNegativo;
    }

    public Meta getMetas() {
        return meta;
    }

    public void setMetas(Meta meta) {
        this.meta = meta;
    }
}