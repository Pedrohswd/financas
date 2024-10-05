package com.gestao.financas.controller;

import com.gestao.financas.dto.MetaDTO;
import com.gestao.financas.model.Meta;
import com.gestao.financas.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/metas")
@Tag(name = "Metas", description = "Endpoints para gerenciamento de metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @Operation(summary = "Criar Meta", description = "Cria uma nova meta.")
    @PostMapping("/criar")
    public ResponseEntity<Meta> criarMeta(@RequestBody MetaDTO metaDTO) {
        Meta meta = metaService.salvarMeta(metaDTO);
        return ResponseEntity.ok(meta);
    }

    @Operation(summary = "Buscar Meta por ID", description = "Busca uma meta pelo seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Meta> buscarMetaPorId(@PathVariable Long id) {
        Meta meta = metaService.buscarPorId(id);
        return ResponseEntity.ok(meta);
    }

    @Operation(summary = "Listar Metas", description = "Lista todas as metas cadastradas.")
    @GetMapping
    public ResponseEntity<List<Meta>> listarMetas() {
        List<Meta> metas = metaService.listarTodos();
        return ResponseEntity.ok(metas);
    }

    @Operation(summary = "Editar Meta", description = "Edita uma meta existente.")
    @PutMapping
    public ResponseEntity<Meta> editarMeta(@RequestBody MetaDTO metaDTO) {
        Meta metas = metaService.salvarMeta(metaDTO);
        return ResponseEntity.ok(metas);
    }

    @Operation(summary = "Excluir Meta", description = "Exclui uma meta pelo seu ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMeta(@PathVariable Long id) {
        metaService.deletarMeta(id);
        return ResponseEntity.noContent().build();
    }
}
