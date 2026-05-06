package com.rpg.controller;

import com.rpg.model.Acessorio;
import com.rpg.model.InventarioItem;
import com.rpg.service.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {

    private final InventarioService service;

    @GetMapping
    public Map<String, Object> listar() {
        return Map.of(
            "itens",      service.listarItens(),
            "acessorios", service.listarAcessorios(),
            "resumo",     service.resumo()
        );
    }

    @PostMapping
    public ResponseEntity<InventarioItem> adicionar(@RequestBody Map<String, String> body) {
        return ResponseEntity.ok(service.adicionarItem(body.get("nome")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.removerItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/acessorios")
    public List<Acessorio> listarAcessorios() {
        return service.listarAcessorios();
    }

    @PatchMapping("/acessorios/{nome}/toggle")
    public ResponseEntity<Acessorio> toggleAcessorio(@PathVariable String nome) {
        return ResponseEntity.ok(service.toggleAcessorio(nome));
    }
}