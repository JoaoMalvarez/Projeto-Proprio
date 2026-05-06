package com.rpg.service;

import com.rpg.model.Atributo;
import com.rpg.repository.AtributoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtributoService {

    private final AtributoRepository repo;

    public List<Atributo> listarTodos() {
        return repo.findAll();
    }

    public Atributo buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Atributo não encontrado: " + id));
    }

    public Atributo atualizar(Long id, Integer novoValor) {
        Atributo atributo = buscarPorId(id);
        atributo.setValor(novoValor);
        return repo.save(atributo);
    }
}