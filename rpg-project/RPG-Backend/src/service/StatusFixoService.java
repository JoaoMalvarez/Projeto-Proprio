package com.rpg.service;

import com.rpg.model.Atributo;
import com.rpg.model.StatusFixo;
import com.rpg.repository.AtributoRepository;
import com.rpg.repository.StatusFixoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatusFixoService {

    private final StatusFixoRepository statusRepo;
    private final AtributoRepository   atributoRepo;

    private static final String CHAVE_VIDA_ATUAL = "vida_atual";

    /** Retorna todos os status calculados + vida atual do banco */
    public Map<String, Integer> calcularStatus() {
        List<Atributo> atributos = atributoRepo.findAll();

        int vitalidade = getValor(atributos, "Vitalidade");
        int intelecto  = getValor(atributos, "Intelecto");

        int pv = 50 + (5 * vitalidade);          // Pontos de Vida total
        int pe = 7  + (2 * intelecto);            // Pontos de Esforço
        int df = 10 + vitalidade + 3;             // Defesa Física (+3 colete)
        int dm = 10 + intelecto;                  // Defesa Mental

        // Vida atual: persiste no banco, inicializa igual ao PV se ainda não existe
        int va = statusRepo.findById(CHAVE_VIDA_ATUAL)
                .map(StatusFixo::getValor)
                .orElseGet(() -> {
                    statusRepo.save(new StatusFixo(CHAVE_VIDA_ATUAL, pv));
                    return pv;
                });

        return Map.of(
            "pv", pv,
            "pe", pe,
            "df", df,
            "dm", dm,
            "va", va
        );
    }

    /** Aplica dano ou cura à vida atual */
    public int alterarVida(int delta) {
        Map<String, Integer> status = calcularStatus();
        int pv = status.get("pv");
        int vaAtual = status.get("va");

        int nova = Math.max(0, Math.min(pv, vaAtual + delta)); // Clamp [0, PV]
        statusRepo.save(new StatusFixo(CHAVE_VIDA_ATUAL, nova));
        return nova;
    }

    /** Restaura a vida ao máximo */
    public int restaurarVida() {
        Map<String, Integer> status = calcularStatus();
        int pv = status.get("pv");
        statusRepo.save(new StatusFixo(CHAVE_VIDA_ATUAL, pv));
        return pv;
    }

    private int getValor(List<Atributo> lista, String nome) {
        return lista.stream()
                .filter(a -> a.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .map(Atributo::getValor)
                .orElse(0);
    }
}