package com.rpg.controller;

import com.rpg.model.Substatus;
import com.rpg.service.SubstatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/substatus")
@RequiredArgsConstructor
public class SubstatusController {

    private final SubstatusService service;

    @GetMapping
    public List<Substatus> listar() {
        return service.listarTodos();
    }

    @GetMapping("/agrupados")
    public Map<String, List<Substatus>> listarAgrupados() {
        return service.listarAgrupados();
    }

    @GetMapping("/{id}")
    public Substatus buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Substatus> atualizar(
            @PathVariable Long id,
            @RequestBody Map<String, Integer> body) {
        return ResponseEntity.ok(service.atualizar(id, body.get("valor")));
    }
}