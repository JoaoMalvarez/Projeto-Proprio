package com.rpg.service;

import com.rpg.model.Acessorio;
import com.rpg.model.InventarioItem;
import com.rpg.repository.AcessorioRepository;
import com.rpg.repository.InventarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final InventarioRepository inventarioRepo;
    private final AcessorioRepository  acessorioRepo;

    private static final int LIMITE_BASE = 2;

    public List<InventarioItem> listarItens() {
        return inventarioRepo.findAll();
    }

    public List<Acessorio> listarAcessorios() {
        return acessorioRepo.findAll();
    }

    public int calcularLimite() {
        int bonus = acessorioRepo.findAll().stream()
                .filter(Acessorio::getEquipado)
                .mapToInt(Acessorio::getBonus)
                .sum();
        return LIMITE_BASE + bonus;
    }

    public InventarioItem adicionarItem(String nome) {
        int atual  = (int) inventarioRepo.count();
        int limite = calcularLimite();
        if (atual >= limite) {
            throw new RuntimeException("Inventário cheio! Limite: " + limite);
        }
        return inventarioRepo.save(new InventarioItem(null, nome, null));
    }

    public void removerItem(Long id) {
        if (!inventarioRepo.existsById(id)) {
            throw new RuntimeException("Item não encontrado: " + id);
        }
        inventarioRepo.deleteById(id);
    }

    public Acessorio toggleAcessorio(String nome) {
        Acessorio acessorio = acessorioRepo.findById(nome)
                .orElseThrow(() -> new RuntimeException("Acessório não encontrado: " + nome));
        acessorio.setEquipado(!acessorio.getEquipado());
        return acessorioRepo.save(acessorio);
    }

    public Map<String, Integer> resumo() {
        return Map.of(
            "itens",  (int) inventarioRepo.count(),
            "limite", calcularLimite()
        );
    }
}