// src/stores/status.js
import { defineStore } from 'pinia'
import { getStatus, patchVida, restaurarVida } from '../api/status'

export const useStatusStore = defineStore('status', {
  state: () => ({ pv: 0, pe: 0, df: 0, dm: 0, va: 0, carregando: false }),

  getters: {
    percentualVida: (s) => s.pv > 0 ? Math.round((s.va / s.pv) * 100) : 0
  },

  actions: {
    async carregar() {
      this.carregando = true
      const { data } = await getStatus()
      Object.assign(this, data)
      this.carregando = false
    },
    async aplicarDano(qtd) {
      const { data } = await patchVida(-Math.abs(qtd))
      this.va = data.va
    },
    async curar(qtd) {
      const { data } = await patchVida(Math.abs(qtd))
      this.va = data.va
    },
    async restaurar() {
      const { data } = await restaurarVida()
      this.va = data.va
    }
  }
})