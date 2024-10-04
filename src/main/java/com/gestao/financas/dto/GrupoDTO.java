package com.gestao.financas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestao.financas.model.Meta;
import com.gestao.financas.model.Pessoa;

import java.util.Set;

public class GrupoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Boolean isSaldoNegativo;
    private PesssoaDTO pessoa;
    private MetaDTO meta;

    public GrupoDTO() {
    }

    public GrupoDTO(Long id, String nome, String descricao, Boolean isSaldoNegativo, MetaDTO meta, PesssoaDTO pessoa) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.isSaldoNegativo = isSaldoNegativo;
        this.meta = meta;
        this.pessoa = pessoa;
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

    public Boolean getIsSaldoNegativo() {
        return isSaldoNegativo;
    }

    public void setIsSaldoNegativo(Boolean isSaldoNegativo) {
        this.isSaldoNegativo = isSaldoNegativo;
    }

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMetaIds(MetaDTO metaId) {
        this.meta = metaId;
    }
}
