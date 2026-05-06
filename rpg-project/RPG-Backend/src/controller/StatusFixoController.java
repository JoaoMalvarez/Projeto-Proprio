package com.rpg.controller;

import com.rpg.service.StatusFixoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class StatusFixoController {

    private final StatusFixoService service;

    /** Retorna pv, pe, df, dm, va calculados */
    @GetMapping
    public Map<String, Integer> calcular() {
        return service.calcularStatus();
    }

    /**
     * Aplica delta à vida atual.
     * Body: { "delta": -10 }  → sofreu 10 de dano
     * Body: { "delta":  5  }  → curou 5 de vida
     */
    @PatchMapping("/vida")
    public ResponseEntity<Map<String, Integer>> alterarVida(@RequestBody Map<String, Integer> body) {
        int novaVida = service.alterarVida(body.get("delta"));
        return ResponseEntity.ok(Map.of("va", novaVida));
    }

    /** Restaura vida ao máximo */
    @PostMapping("/vida/restaurar")
    public ResponseEntity<Map<String, Integer>> restaurarVida() {
        int vida = service.restaurarVida();
        return ResponseEntity.ok(Map.of("va", vida));
    }
}