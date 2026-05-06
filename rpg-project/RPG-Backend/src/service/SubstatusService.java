package com.rpg.service;

import com.rpg.model.Substatus;
import com.rpg.repository.SubstatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubstatusService {

    private final SubstatusRepository repo;

    public List<Substatus> listarTodos() {
        return repo.findAll();
    }

    /** Retorna os substatus agrupados por categoria — útil para o frontend renderizar por seção */
    public Map<String, List<Substatus>> listarAgrupados() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(Substatus::getCategoria));
    }

    public Substatus buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Substatus não encontrado: " + id));
    }

    public Substatus atualizar(Long id, Integer novoValor) {
        Substatus sub = buscarPorId(id);
        sub.setValor(novoValor);
        return repo.save(sub);
    }
}