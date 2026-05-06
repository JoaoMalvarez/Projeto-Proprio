<template>
  <div>
    <h2>Resumo da Ficha</h2>
    <p class="hint">Visão geral do seu personagem.</p>

    <div class="grid">
      <div class="card" v-for="card in cards" :key="card.label">
        <RouterLink :to="card.to" class="card-link">
          <span class="card-icon">{{ card.icon }}</span>
          <span class="card-label">{{ card.label }}</span>
          <span class="card-arrow">→</span>
        </RouterLink>
      </div>
    </div>
  </div>
</template>

<script setup>
const cards = [
  { to: '/status',     icon: '❤️',  label: 'Status Fixos'  },
  { to: '/atributos',  icon: '🎲', label: 'Atributos'     },
  { to: '/substatus',  icon: '📊', label: 'Substatus'     },
  { to: '/inventario', icon: '🎒', label: 'Inventário'    },
]
</script>

<style scoped>
h2 { margin-bottom: 0.3rem; }
.hint { color: var(--text-muted); margin-bottom: 2rem; }

.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(180px, 1fr));
  gap: 1rem;
}

.card {
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: var(--radius-lg);
  transition: border-color var(--transition), box-shadow var(--transition);
}
.card:hover {
  border-color: var(--accent);
  box-shadow: 0 0 12px var(--accent-glow);
}

.card-link {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.5rem;
  padding: 1.5rem 1rem;
  color: var(--text-primary);
  font-size: 1rem;
}
.card-icon { font-size: 2rem; }
.card-label { font-family: var(--font-title); font-size: 0.95rem; }
.card-arrow { color: var(--text-muted); font-size: 0.85rem; }
</style>