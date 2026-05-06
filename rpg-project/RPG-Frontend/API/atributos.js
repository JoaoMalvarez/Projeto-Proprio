// src/api/atributos.js
import api from './client'

export const getAtributos    = ()         => api.get('/atributos')
export const patchAtributo   = (id, val)  => api.patch(`/atributos/${id}`, { valor: val })