package com.gestao.financas.service;

import com.gestao.financas.dto.GrupoDTO;
import com.gestao.financas.model.Grupo;
import com.gestao.financas.model.Meta;
import com.gestao.financas.repository.GrupoRepository;
import com.gestao.financas.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private MetaRepository metaRepository;

    @Autowired
    private PessoaService pessoaService;

    public void atualizarSaldoNegativo(Grupo grupo, boolean saldoNegativo) {
        grupo.setSaldoNegativo(saldoNegativo);
        grupoRepository.save(grupo);
    }

    public Grupo salvar(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public Grupo buscarPorId(Long id) {
        return grupoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Grupo não encontrada"));
    }

    public List<Grupo> buscarTodos() {
        return grupoRepository.findAll();
    }

    public void excluir(Long id) {
        grupoRepository.deleteById(id);
    }


    public Grupo salvarGrupo(GrupoDTO grupoDTO) {
        // Criar a entidade Grupo
        Grupo grupo = new Grupo();
        grupo.setId(grupoDTO.getId());
        grupo.setNome(grupoDTO.getNome());
        grupo.setDescricao(grupoDTO.getDescricao());
        grupo.setSaldoNegativo(grupoDTO.getIsSaldoNegativo());
        grupo.setMetas(metaRepository.findById(grupoDTO.getMeta().getId()).orElseThrow());
        grupo.setPessoa(pessoaService.buscarPorId(grupoDTO.getPessoa().getId()).orElseThrow());


        return grupoRepository.save(grupo);
    }


}
