<template>
  <div>
    <h2>Inventário</h2>
    <p class="hint">
      Capacidade: <strong>{{ store.resumo.itens }} / {{ store.resumo.limite }}</strong>
    </p>

    <div v-if="store.carregando" class="loading">Carregando...</div>

    <div v-else class="layout">
      <!-- Lista de itens -->
      <section class="secao">
        <h3>Itens</h3>

        <div class="add-row">
          <input v-model="novoItem" placeholder="Nome do item..." @keyup.enter="adicionar" />
          <button class="primary" @click="adicionar">+ Adicionar</button>
        </div>

        <p v-if="store.itens.length === 0" class="vazio">Inventário vazio.</p>

        <ul class="lista" v-else>
          <li v-for="item in store.itens" :key="item.id" class="item">
            <span>{{ item.nome }}</span>
            <button class="danger small" @click="remover(item.id)">✕</button>
          </li>
        </ul>
      </section>

      <!-- Acessórios -->
      <section class="secao">
        <h3>Acessórios</h3>
        <div class="acessorios">
          <div
            class="acessorio"
            v-for="ac in store.acessorios"
            :key="ac.nome"
            :class="{ equipado: ac.equipado }"
            @click="toggle(ac.nome)"
          >
            <span class="ac-nome">{{ ac.nome }}</span>
            <span class="ac-bonus">+{{ ac.bonus }} slots</span>
            <span class="ac-status">{{ ac.equipado ? '✔ Equipado' : 'Desequipado' }}</span>
          </div>
        </div>
      </section>
    </div>

    <p v-if="erro" class="erro">{{ erro }}</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useInventarioStore } from '../stores/inventario'

const store    = useInventarioStore()
const novoItem = ref('')
const erro     = ref('')

onMounted(() => store.carregar())

const adicionar = async () => {
  const nome = novoItem.value.trim()
  if (!nome) return
  try {
    erro.value = ''
    await store.adicionar(nome)
    novoItem.value = ''
  } catch (e) {
    erro.value = e?.response?.data?.message ?? 'Inventário cheio!'
  }
}

const remover = (id) => store.remover(id)
const toggle  = (nome) => store.toggle(nome)
</script>

<style scoped>
h2 { margin-bottom: 0.3rem; }
.hint { color: var(--text-muted); margin-bottom: 2rem; }
.loading { color: var(--text-muted); }

.layout {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 2rem;
  align-items: start;
}

.secao h3 {
  color: var(--text-muted);
  font-size: 0.9rem;
  margin-bottom: 0.75rem;
  border-bottom: 1px solid var(--border);
  padding-bottom: 0.3rem;
}

.add-row {
  display: flex;
  gap: 0.5rem;
  margin-bottom: 1rem;
}
.add-row input { flex: 1; }

.vazio { color: var(--text-muted); font-style: italic; }

.lista { list-style: none; display: flex; flex-direction: column; gap: 0.5rem; }
.item {
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: var(--radius);
  padding: 0.6rem 0.9rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
button.small { padding: 0.2rem 0.6rem; font-size: 0.85rem; }

.acessorios { display: flex; flex-direction: column; gap: 0.75rem; }
.acessorio {
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: var(--radius);
  padding: 0.8rem 1rem;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 1rem;
  transition: border-color var(--transition);
}
.acessorio:hover { border-color: var(--accent-dim); }
.acessorio.equipado { border-color: var(--accent); background: var(--accent-glow); }

.ac-nome { flex: 1; font-family: var(--font-title); font-size: 0.9rem; }
.ac-bonus { color: var(--text-muted); font-size: 0.85rem; }
.ac-status { font-size: 0.8rem; color: var(--accent); min-width: 90px; text-align: right; }

.erro { color: var(--red); margin-top: 1rem; }

@media (max-width: 700px) {
  .layout { grid-template-columns: 1fr; }
}
</style>