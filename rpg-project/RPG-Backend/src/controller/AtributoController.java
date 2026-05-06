package com.rpg.controller;

import com.rpg.model.Atributo;
import com.rpg.service.AtributoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/atributos")
@RequiredArgsConstructor
public class AtributoController {

    private final AtributoService service;

    @GetMapping
    public List<Atributo> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Atributo buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Atributo> atualizar(
            @PathVariable Long id,
            @RequestBody Map<String, Integer> body) {
        return ResponseEntity.ok(service.atualizar(id, body.get("valor")));
    }
}