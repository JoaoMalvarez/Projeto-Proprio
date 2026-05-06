// src/api/client.js
// Instância axios centralizada — troca só o baseURL aqui quando for pro servidor
import axios from 'axios'

const api = axios.create({
  baseURL: '/api',
  headers: { 'Content-Type': 'application/json' }
})

export default api