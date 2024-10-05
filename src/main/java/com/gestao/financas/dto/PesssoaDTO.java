package com.gestao.financas.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados da pessoa")
public class PesssoaDTO {

    @Schema(description = "Identificador da pessoa", example = "1")
    private Long id;

    @Schema(description = "Nome da pessoa", example = "Pedro Henrique")
    private String nome;

    @Schema(description = "CPF da pessoa", example = "123.456.789-00")
    private String cpf;

    @Schema(description = "E-mail da pessoa", example = "pedro@example.com")
    private String email;

    @Schema(description = "Telefone da pessoa", example = "(62) 99999-9999")
    private String telefone;

    public PesssoaDTO() {
    }

    public PesssoaDTO(Long id, String nome, String cpf, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
