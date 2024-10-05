package com.gestao.financas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pessoa")
@Schema(description = "Dados da pessoa associada aos grupos financeiros")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador da pessoa", example = "1")
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    @Schema(description = "Nome da pessoa", example = "Pedro Henrique")
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    @Schema(description = "CPF da pessoa", example = "123.456.789-00")
    private String cpf;

    @Column(nullable = false, unique = true, length = 100)
    @Schema(description = "E-mail da pessoa", example = "pedro@example.com")
    private String email;

    @Column(nullable = false, length = 15)
    @Schema(description = "Telefone da pessoa", example = "(62) 99999-9999")
    private String telefone;

    @OneToMany
    @JoinColumn(name = "pessoa_id")
    @Schema(description = "Lista de grupos financeiros associados à pessoa")
    private List<Grupo> grupos;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String cpf, String email, String telefone) {
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