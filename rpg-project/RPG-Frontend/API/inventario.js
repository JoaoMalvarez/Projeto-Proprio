// src/api/inventario.js
import api from './client'

export const getInventario     = ()     => api.get('/inventario')
export const postItem          = (nome) => api.post('/inventario', { nome })
export const deleteItem        = (id)   => api.delete(`/inventario/${id}`)
export const toggleAcessorio   = (nome) => api.patch(`/inventario/acessorios/${encodeURIComponent(nome)}/toggle`)