package com.gestao.financas.dto;

import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;
import com.gestao.financas.model.Grupo;

import java.time.LocalDate;

public class LancamentoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDate data;
    private Tipo tipo;
    private Double valor;
    private Categoria categoria;
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