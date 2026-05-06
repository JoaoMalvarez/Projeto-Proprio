// src/stores/atributos.js
import { defineStore } from 'pinia'
import { getAtributos, patchAtributo } from '../api/atributos'

export const useAtributosStore = defineStore('atributos', {
  state: () => ({ lista: [], carregando: false }),

  actions: {
    async carregar() {
      this.carregando = true
      const { data } = await getAtributos()
      this.lista = data
      this.carregando = false
    },
    async atualizar(id, valor) {
      const { data } = await patchAtributo(id, valor)
      const idx = this.lista.findIndex(a => a.id === id)
      if (idx !== -1) this.lista[idx] = data
    }
  }
})