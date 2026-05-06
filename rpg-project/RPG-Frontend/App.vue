<template>
  <div class="layout">
    <nav class="sidebar">
      <div class="sidebar-header">
        <h1>⚔ Ficha</h1>
        <p class="subtitle">RPG</p>
      </div>

      <ul class="nav-links">
        <li v-for="link in links" :key="link.to">
          <RouterLink :to="link.to" :class="{ active: route.path === link.to }">
            <span class="icon">{{ link.icon }}</span>
            <span>{{ link.label }}</span>
          </RouterLink>
        </li>
      </ul>
    </nav>

    <main class="content">
      <RouterView />
    </main>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router'
const route = useRoute()

const links = [
  { to: '/',           icon: '📋', label: 'Resumo'     },
  { to: '/status',     icon: '❤️',  label: 'Status'     },
  { to: '/atributos',  icon: '🎲', label: 'Atributos'  },
  { to: '/substatus',  icon: '📊', label: 'Substatus'  },
  { to: '/inventario', icon: '🎒', label: 'Inventário' },
]
</script>

<style scoped>
.layout {
  display: flex;
  min-height: 100vh;
}

.sidebar {
  width: 220px;
  flex-shrink: 0;
  background: var(--bg-card);
  border-right: 1px solid var(--border);
  display: flex;
  flex-direction: column;
  padding: 1.5rem 0;
}

.sidebar-header {
  padding: 0 1.5rem 1.5rem;
  border-bottom: 1px solid var(--border);
  margin-bottom: 1rem;
}
.sidebar-header h1 { font-size: 1.4rem; }
.subtitle { color: var(--text-muted); font-size: 0.85rem; margin-top: 0.2rem; }

.nav-links {
  list-style: none;
  display: flex;
  flex-direction: column;
  gap: 0.2rem;
  padding: 0 0.75rem;
}

.nav-links a {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  padding: 0.6rem 0.75rem;
  border-radius: var(--radius);
  color: var(--text-muted);
  transition: all var(--transition);
  font-size: 1rem;
}
.nav-links a:hover,
.nav-links a.active {
  background: var(--accent-glow);
  color: var(--accent);
  border: 1px solid var(--accent-dim);
}
.nav-links a.active { font-weight: 600; }

.content {
  flex: 1;
  padding: 2rem;
  overflow-y: auto;
}
</style>