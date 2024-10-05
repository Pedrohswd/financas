package com.gestao.financas.controller;

import com.gestao.financas.dto.LancamentoDTO;
import com.gestao.financas.model.Lancamento;
import com.gestao.financas.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/lancamentos")
@Tag(name = "Lançamentos", description = "Endpoints para gerenciamento de lançamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Operation(summary = "Criar Lançamento", description = "Cria um novo lançamento.")
    @PostMapping("/criar")
    public ResponseEntity<?> criarLancamento(@RequestBody LancamentoDTO lancamentoDTO) {
        Lancamento lancamento = lancamentoService.criarLancamento(
                lancamentoDTO.getId(),
                lancamentoDTO.getNome(),
                lancamentoDTO.getDescricao(),
                lancamentoDTO.getData(),
                lancamentoDTO.getTipo(),
                lancamentoDTO.getValor(),
                lancamentoDTO.getCategoria(),
                lancamentoDTO.getGrupo()
        );
        if (lancamento.isNegativouGrupo()) {
            return ResponseEntity.ok("O grupo ficou negativado após este lançamento.");
        }
        return ResponseEntity.ok(lancamento);
    }

    @Operation(summary = "Buscar Lançamento por ID", description = "Busca um lançamento pelo seu ID.")
    @GetMapping("/{id}")
    public Optional<Lancamento> buscarLancamentoPorId(@PathVariable Long id) {
        return lancamentoService.buscarPorId(id);
    }

    @Operation(summary = "Listar Lançamentos", description = "Lista todos os lançamentos cadastrados.")
    @GetMapping("/listar")
    public List<Lancamento> listarLancamentos() {
        return lancamentoService.listarTodos();
    }

    @Operation(summary = "Atualizar Lançamento", description = "Atualiza um lançamento existente.")
    @PutMapping("/atualizar/{id}")
    public Lancamento atualizarLancamento(@PathVariable Long id, @RequestBody LancamentoDTO lancamentoDTO) {
        return lancamentoService.atualizarLancamento(id, lancamentoDTO);
    }

    @Operation(summary = "Deletar Lançamento", description = "Exclui um lançamento pelo seu ID.")
    @DeleteMapping("/deletar/{id}")
    public void deletarLancamento(@PathVariable Long id) {
        lancamentoService.deletarLancamento(id);
    }
}