package com.gestao.financas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gestao.financas.model.Meta;
import com.gestao.financas.model.Pessoa;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;


@Schema(description = "Dados do grupo financeiro")
public class GrupoDTO {

    @Schema(description = "Identificador do grupo", example = "1")
    private Long id;

    @Schema(description = "Nome do grupo", example = "Investimentos")
    private String nome;

    @Schema(description = "Descrição do grupo", example = "Grupo destinado a investimentos de longo prazo")
    private String descricao;

    @Schema(description = "Indica se o grupo possui saldo negativo", example = "false")
    private Boolean isSaldoNegativo;

    @Schema(description = "Pessoa responsável pelo grupo")
    private PesssoaDTO pessoa;

    @Schema(description = "Meta associada ao grupo")
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

    public Boolean getSaldoNegativo() {
        return isSaldoNegativo;
    }

    public void setSaldoNegativo(Boolean saldoNegativo) {
        isSaldoNegativo = saldoNegativo;
    }

    public PesssoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PesssoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMetaIds(MetaDTO metaId) {
        this.meta = metaId;
    }
}
