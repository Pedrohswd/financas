package com.gestao.financas.service;

import com.gestao.financas.dto.MetaDTO;
import com.gestao.financas.enuns.Categoria;
import com.gestao.financas.model.Grupo;
import com.gestao.financas.model.Meta;
import com.gestao.financas.repository.MetaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;
    @Autowired
    private GrupoService grupoService;



    @Transactional
    public void atualizarValorMeta(Long metaId, Double valorLancamento, boolean isDespesa) {
        Optional<Meta> metaOpt = metaRepository.findById(metaId);

        if (metaOpt.isPresent()) {
            Meta meta = metaOpt.get();
            Double valorAtual = isDespesa ? meta.getValorAtual() - valorLancamento : meta.getValorAtual() + valorLancamento;

            meta.setValorAtual(valorAtual);
            metaRepository.save(meta);

            if (valorAtual < 0) {
                grupoService.atualizarSaldoNegativo(meta.getGrupo(), true);
            }
        }
    }
    public Meta buscarPorId(Long id) {
        return metaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não encontrada"));
    }

    public List<Meta> listarTodos() {
        return metaRepository.findAll();
    }

    public void deletarMeta(Long id) {
        Meta meta = metaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não encontrada"));
        metaRepository.delete(meta);
    }

    public Meta salvarMeta(MetaDTO metaDTO) {

        Meta meta = new Meta();
        meta.setId(metaDTO.getId());
        meta.setDescricao(metaDTO.getDescricao());
        meta.setValorObjetivo(metaDTO.getValorObjetivo());
        meta.setValorAtual(metaDTO.getValorAtual());

        return metaRepository.save(meta);
    }
}
