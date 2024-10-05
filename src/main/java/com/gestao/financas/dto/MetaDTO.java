package com.gestao.financas.dto;

import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.enuns.Tipo;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados da meta financeira")
public class MetaDTO {

    @Schema(description = "Identificador da meta", example = "1")
    private Long id;

    @Schema(description = "Descrição da meta", example = "Meta para reserva de emergência")
    private String descricao;

    @Schema(description = "Valor objetivo da meta", example = "10000.00")
    private Double valorObjetivo;

    @Schema(description = "Valor atual da meta", example = "4500.00")
    private Double valorAtual;

    @Schema(description = "Identificador do grupo associado", example = "1")
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
