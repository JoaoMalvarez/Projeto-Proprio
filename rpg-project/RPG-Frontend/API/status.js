// src/api/status.js
import api from './client'

export const getStatus      = ()      => api.get('/status')
export const patchVida      = (delta) => api.patch('/status/vida', { delta })
export const restaurarVida  = ()      => api.post('/status/vida/restaurar')