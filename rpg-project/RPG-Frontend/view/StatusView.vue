<template>
  <div>
    <h2>Status Fixos</h2>
    <p class="hint">Calculados automaticamente a partir dos atributos.</p>

    <div v-if="store.carregando" class="loading">Carregando...</div>

    <div v-else class="status-grid">
      <!-- Vida com barra -->
      <div class="card vida-card">
        <div class="stat-header">
          <span class="stat-label">Pontos de Vida</span>
          <span class="stat-value">{{ store.va }} / {{ store.pv }}</span>
        </div>
        <div class="barra-bg">
          <div class="barra-fill" :style="{ width: store.percentualVida + '%' }"
               :class="vidaClasse"></div>
        </div>

        <div class="vida-actions">
          <input v-model.number="delta" type="number" min="1" placeholder="qtd" />
          <button class="danger" @click="aplicarDano">⚔ Dano</button>
          <button @click="curar">💚 Curar</button>
          <button @click="restaurar">✨ Full</button>
        </div>
      </div>

      <!-- Outros stats -->
      <div class="card" v-for="s in outrosStats" :key="s.label">
        <span class="stat-label">{{ s.label }}</span>
        <span class="stat-value big">{{ s.valor }}</span>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { useStatusStore } from '../stores/status'

const store = useStatusStore()
const delta = ref(1)

onMounted(() => store.carregar())

const vidaClasse = computed(() => {
  const p = store.percentualVida
  if (p > 60) return 'verde'
  if (p > 30) return 'amarelo'
  return 'vermelho'
})

const outrosStats = computed(() => [
  { label: 'Pontos de Esforço', valor: store.pe },
  { label: 'Defesa Física',     valor: store.df },
  { label: 'Defesa Mental',     valor: store.dm },
])

const aplicarDano = () => delta.value > 0 && store.aplicarDano(delta.value)
const curar       = () => delta.value > 0 && store.curar(delta.value)
const restaurar   = () => store.restaurar()
</script>

<style scoped>
h2 { margin-bottom: 0.3rem; }
.hint { color: var(--text-muted); margin-bottom: 2rem; }
.loading { color: var(--text-muted); }

.status-grid {
  display: grid;
  grid-template-columns: 1fr repeat(3, auto);
  gap: 1rem;
  align-items: start;
}

.card {
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: var(--radius-lg);
  padding: 1.25rem 1.5rem;
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.vida-card { grid-column: 1; }

.stat-header {
  display: flex;
  justify-content: space-between;
  align-items: baseline;
}
.stat-label { color: var(--text-muted); font-size: 0.9rem; font-family: var(--font-title); }
.stat-value { font-size: 1.2rem; font-weight: 600; color: var(--accent); }
.stat-value.big { font-size: 2rem; }

.barra-bg {
  width: 100%;
  height: 10px;
  background: var(--bg-elevated);
  border-radius: 99px;
  overflow: hidden;
}
.barra-fill {
  height: 100%;
  border-radius: 99px;
  transition: width 0.4s ease, background 0.4s ease;
}
.verde   { background: var(--green); }
.amarelo { background: var(--accent); }
.vermelho{ background: var(--red); }

.vida-actions {
  display: flex;
  gap: 0.5rem;
  align-items: center;
  margin-top: 0.5rem;
  flex-wrap: wrap;
}
.vida-actions input { width: 70px; }

@media (max-width: 700px) {
  .status-grid { grid-template-columns: 1fr; }
  .vida-card { grid-column: 1; }
}
</style>