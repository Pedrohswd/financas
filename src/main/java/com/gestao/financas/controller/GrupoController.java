package com.gestao.financas.controller;

import com.gestao.financas.dto.GrupoDTO;
import com.gestao.financas.model.Grupo;
import com.gestao.financas.service.GrupoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@Tag(name = "Grupos", description = "Endpoints para gerenciamento de grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @Operation(summary = "Buscar Grupo por ID", description = "Busca um grupo pelo seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Grupo> buscarGrupoPorId(@PathVariable Long id) {
        Grupo grupo = grupoService.buscarPorId(id);
        return ResponseEntity.ok(grupo);
    }

    @Operation(summary = "Listar Grupos", description = "Lista todos os grupos cadastrados.")
    @GetMapping
    public ResponseEntity<List<Grupo>> listarGrupos() {
        List<Grupo> grupos = grupoService.buscarTodos();
        return ResponseEntity.ok(grupos);
    }

    @Operation(summary = "Excluir Grupo", description = "Exclui um grupo pelo seu ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirGrupo(@PathVariable Long id) {
        grupoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Criar Grupo", description = "Cria um novo grupo.")
    @PostMapping("/criar")
    public ResponseEntity<Grupo> criarGrupo(@RequestBody GrupoDTO grupoDTO) {
        Grupo grupo = grupoService.salvarGrupo(grupoDTO);
        return ResponseEntity.ok(grupo);
    }

    @Operation(summary = "Salvar Grupo", description = "Salva um grupo existente.")
    @PutMapping("/salvar")
    public ResponseEntity<Grupo> salvarGrupo(@RequestBody Grupo grupo) {
        Grupo grupoSalvo = grupoService.salvar(grupo);
        return ResponseEntity.ok(grupoSalvo);
    }
}
