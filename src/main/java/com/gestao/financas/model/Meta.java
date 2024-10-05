package com.gestao.financas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "meta")
@Schema(description = "Meta financeira relacionada a um grupo")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador da meta", example = "1")
    private Long id;

    @Schema(description = "Descrição da meta", example = "Meta para reserva de emergência")
    private String descricao;

    @Column(nullable = false)
    @Schema(description = "Valor objetivo da meta", example = "10000.00")
    private Double valorObjetivo;

    @Column(nullable = false)
    @Schema(description = "Valor atual da meta", example = "4500.00")
    private Double valorAtual;

    @OneToOne
    @Schema(description = "Grupo financeiro associado à meta")
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