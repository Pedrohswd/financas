package com.gestao.financas.dto;

import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;
import com.gestao.financas.model.Grupo;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Dados do lançamento financeiro")
public class LancamentoDTO {

    @Schema(description = "Identificador do lançamento", example = "1")
    private Long id;

    @Schema(description = "Nome do lançamento", example = "Salário")
    private String nome;

    @Schema(description = "Descrição do lançamento", example = "Recebimento de salário")
    private String descricao;

    @Schema(description = "Data do lançamento", example = "2024-10-05")
    private LocalDate data;

    @Schema(description = "Tipo do lançamento", example = "RECEITA")
    private Tipo tipo;

    @Schema(description = "Valor do lançamento", example = "3500.00")
    private Double valor;

    @Schema(description = "Categoria do lançamento", example = "SALARIO")
    private Categoria categoria;

    @Schema(description = "Grupo associado ao lançamento")
    private GrupoDTO grupo;

    public LancamentoDTO() {
    }

    public LancamentoDTO(Long id, String nome, String descricao, LocalDate data, Tipo tipo, Double valor, Categoria categoria, GrupoDTO grupoDTO) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.grupo = grupoDTO;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public GrupoDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDTO grupo) {
        this.grupo = grupo;
    }
}