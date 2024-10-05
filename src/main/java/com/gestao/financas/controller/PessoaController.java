package com.gestao.financas.controller;

import com.gestao.financas.dto.LancamentoDTO;
import com.gestao.financas.dto.PesssoaDTO;
import com.gestao.financas.model.Lancamento;
import com.gestao.financas.model.Pessoa;
import com.gestao.financas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pessoas")
@Tag(name = "Pessoas", description = "Endpoints para gerenciamento de pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Operation(summary = "Criar Pessoa", description = "Cria uma nova pessoa.")
    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaService.salvar(pessoa);
        return ResponseEntity.ok(novaPessoa);
    }

    @Operation(summary = "Buscar Pessoa por ID", description = "Busca uma pessoa pelo seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.buscarPorId(id);
        return pessoa.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Listar Pessoas", description = "Lista todas as pessoas cadastradas.")
    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaService.buscarTodas();
        return ResponseEntity.ok(pessoas);
    }

    @Operation(summary = "Atualizar Pessoa", description = "Atualiza os dados de uma pessoa existente.")
    @PutMapping("/atualizar/{id}")
    public Pessoa atualizarLancamento(@PathVariable Long id, @RequestBody PesssoaDTO pesssoaDTO) {
        return pessoaService.atualizarPessoa(id, pesssoaDTO);
    }

    @Operation(summary = "Excluir Pessoa", description = "Exclui uma pessoa pelo seu ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
