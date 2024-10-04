package com.gestao.financas.dto;

import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;

public class MetaDTO {

    private Long id;
    private String descricao;
    private Double valorObjetivo;
    private Double valorAtual;
    private Long grupoId;

    public MetaDTO() {
    }

    public MetaDTO(Long id, String descricao, Double valorObjetivo, Double valorAtual, Long grupoId, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valorObjetivo = valorObjetivo;
        this.valorAtual = valorAtual;
        this.grupoId = grupoId;
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

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }
}
