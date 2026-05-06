// src/api/substatus.js
import api from './client'

export const getSubstatusAgrupados = ()        => api.get('/substatus/agrupados')
export const patchSubstatus        = (id, val) => api.patch(`/substatus/${id}`, { valor: val })