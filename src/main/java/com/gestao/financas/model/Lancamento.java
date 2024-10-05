package com.gestao.financas.model;

import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento")
@Schema(description = "Lançamento financeiro registrado no sistema")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador do lançamento", example = "1")
    private Long id;

    @Column(nullable = false, length = 100)
    @Schema(description = "Nome do lançamento", example = "Salário")
    private String nome;

    @Column(length = 255)
    @Schema(description = "Descrição do lançamento", example = "Recebimento de salário")
    private String descricao;

    @Column(nullable = false)
    @Schema(description = "Data do lançamento", example = "2024-10-05")
    private LocalDate data;

    @Column(nullable = false, length = 50)
    @Schema(description = "Tipo do lançamento", example = "RECEITA")
    private Tipo tipo;

    @Column(nullable = false)
    @Schema(description = "Valor do lançamento", example = "3500.00")
    private Double valor;

    @Column(nullable = false, length = 50)
    @Schema(description = "Categoria do lançamento", example = "SALARIO")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    @Schema(description = "Grupo financeiro associado ao lançamento")
    private Grupo grupo;

    @Transient
    @Schema(description = "Indica se o grupo ficou negativo com o lançamento", example = "false")
    private boolean negativouGrupo;


    public Lancamento() {
    }

    public Lancamento(Long id, String nome, String descricao, LocalDate data, Tipo tipo, Double valor, Categoria categoria, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.grupo = grupo;
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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public boolean isNegativouGrupo() {
        return negativouGrupo;
    }
    public void setNegativouGrupo(boolean negativouGrupo) {
        this.negativouGrupo = negativouGrupo;
    }
}