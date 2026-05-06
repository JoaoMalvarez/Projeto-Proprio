<template>
  <div>
    <h2>Atributos</h2>
    <p class="hint">Dados base do personagem. Clique para editar.</p>

    <div v-if="store.carregando" class="loading">Carregando...</div>

    <div v-else class="grid">
      <div
        class="card"
        v-for="atr in store.lista"
        :key="atr.id"
        @click="abrirEdicao(atr)"
        :class="{ editando: editId === atr.id }"
      >
        <span class="nome">{{ atr.nome }}</span>
        <span class="valor">{{ atr.valor }}</span>

        <div v-if="editId === atr.id" class="edit-row" @click.stop>
          <input v-model.number="editValor" type="number" min="0" max="20" />
          <button class="primary" @click="salvar(atr.id)">✔</button>
          <button @click="editId = null">✘</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useAtributosStore } from '../stores/atributos'

const store  = useAtributosStore()
const editId = ref(null)
const editValor = ref(0)

onMounted(() => store.carregar())

const abrirEdicao = (atr) => {
  editId.value    = atr.id
  editValor.value = atr.valor
}

const salvar = async (id) => {
  await store.atualizar(id, editValor.value)
  editId.value = null
}
</script>

<style scoped>
h2 { margin-bottom: 0.3rem; }
.hint { color: var(--text-muted); margin-bottom: 2rem; }
.loading { color: var(--text-muted); }

.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
  gap: 1rem;
}

.card {
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: var(--radius-lg);
  padding: 1.25rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.5rem;
  cursor: pointer;
  transition: border-color var(--transition), box-shadow var(--transition);
}
.card:hover, .card.editando {
  border-color: var(--accent);
  box-shadow: 0 0 10px var(--accent-glow);
}

.nome { font-family: var(--font-title); font-size: 0.85rem; color: var(--text-muted); }
.valor { font-size: 2.5rem; font-weight: 700; color: var(--accent); }

.edit-row {
  display: flex;
  gap: 0.4rem;
  align-items: center;
}
.edit-row input { width: 60px; text-align: center; }
</style>