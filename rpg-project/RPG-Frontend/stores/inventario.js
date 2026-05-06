// src/stores/inventario.js
import { defineStore } from 'pinia'
import { getInventario, postItem, deleteItem, toggleAcessorio } from '../api/inventario'

export const useInventarioStore = defineStore('inventario', {
  state: () => ({
    itens: [],
    acessorios: [],
    resumo: { itens: 0, limite: 2 },
    carregando: false
  }),

  actions: {
    async carregar() {
      this.carregando = true
      const { data } = await getInventario()
      this.itens      = data.itens
      this.acessorios = data.acessorios
      this.resumo     = data.resumo
      this.carregando = false
    },
    async adicionar(nome) {
      await postItem(nome)
      await this.carregar()
    },
    async remover(id) {
      await deleteItem(id)
      await this.carregar()
    },
    async toggle(nome) {
      await toggleAcessorio(nome)
      await this.carregar()
    }
  }
})