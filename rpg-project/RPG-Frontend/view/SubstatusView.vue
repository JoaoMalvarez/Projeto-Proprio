<template>
  <div>
    <h2>Substatus</h2>
    <p class="hint">Clique num substatus para editar o valor.</p>

    <div v-if="carregando" class="loading">Carregando...</div>

    <div v-else>
      <section v-for="(itens, categoria) in agrupados" :key="categoria" class="secao">
        <h3>{{ categoriaIcon(categoria) }} {{ categoria }}</h3>
        <div class="grid">
          <div
            class="card"
            v-for="sub in itens"
            :key="sub.id"
            @click="abrirEdicao(sub)"
            :class="{ editando: editId === sub.id, zerado: sub.valor === 0 }"
          >
            <span class="nome">{{ sub.nome }}</span>
            <span class="valor">{{ sub.valor }}</span>

            <div v-if="editId === sub.id" class="edit-row" @click.stop>
              <input v-model.number="editValor" type="number" min="0" />
              <button class="primary" @click="salvar(sub.id)">✔</button>
              <button @click="editId = null">✘</button>
            </div>
          </div>
        </div>
      </section>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getSubstatusAgrupados, patchSubstatus } from '../api/substatus'

const agrupados  = ref({})
const carregando = ref(true)
const editId     = ref(null)
const editValor  = ref(0)

onMounted(async () => {
  const { data } = await getSubstatusAgrupados()
  agrupados.value = data
  carregando.value = false
})

const abrirEdicao = (sub) => {
  editId.value    = sub.id
  editValor.value = sub.valor
}

const salvar = async (id) => {
  const { data } = await patchSubstatus(id, editValor.value)
  // Atualiza local sem refetch
  for (const cat of Object.values(agrupados.value)) {
    const idx = cat.findIndex(s => s.id === id)
    if (idx !== -1) { cat[idx] = data; break }
  }
  editId.value = null
}

const categoriaIcon = (cat) => ({
  'Práticas': '🛠',
  'Combate':  '🔫',
  'Mental':   '👁',
  'Extras':   '⚡',
}[cat] ?? '📌')
</script>

<style scoped>
h2 { margin-bottom: 0.3rem; }
.hint { color: var(--text-muted); margin-bottom: 2rem; }
.loading { color: var(--text-muted); }

.secao { margin-bottom: 2rem; }
.secao h3 {
  font-size: 1rem;
  color: var(--text-muted);
  margin-bottom: 0.75rem;
  border-bottom: 1px solid var(--border);
  padding-bottom: 0.3rem;
}

.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(160px, 1fr));
  gap: 0.75rem;
}

.card {
  background: var(--bg-card);
  border: 1px solid var(--border);
  border-radius: var(--radius);
  padding: 0.85rem 1rem;
  display: flex;
  flex-direction: column;
  gap: 0.3rem;
  cursor: pointer;
  transition: border-color var(--transition);
}
.card:hover, .card.editando { border-color: var(--accent); }
.card.zerado { opacity: 0.45; }

.nome { font-size: 0.82rem; color: var(--text-muted); font-family: var(--font-title); }
.valor { font-size: 1.6rem; font-weight: 700; color: var(--accent); }

.edit-row { display: flex; gap: 0.3rem; align-items: center; }
.edit-row input { width: 55px; text-align: center; }
</style>