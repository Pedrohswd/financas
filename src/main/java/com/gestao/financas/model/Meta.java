package com.gestao.financas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "meta")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String descricao;

    @Column(nullable = false)
    private Double valorObjetivo;

    @Column(nullable = false)
    private Double valorAtual;

    @OneToOne
    @JsonIgnore
    private Grupo grupo;

    public Meta() {
    }

    public Meta(Long id, String descricao, Double valorObjetivo, Double valorAtual, Grupo grupo) {
        this.id = id;
        this.descricao = descricao;
        this.valorObjetivo = valorObjetivo;
        this.valorAtual = valorAtual;
        this.grupo = grupo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(Double valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public Double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}