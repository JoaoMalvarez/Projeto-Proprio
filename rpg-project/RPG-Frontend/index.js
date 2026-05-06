// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'

import FichaView    from '../views/FichaView.vue'
import AtributosView  from '../views/AtributosView.vue'
import SubstatusView  from '../views/SubstatusView.vue'
import InventarioView from '../views/InventarioView.vue'
import StatusView     from '../views/StatusView.vue'

const routes = [
  { path: '/',           component: FichaView,      name: 'ficha'      },
  { path: '/atributos',  component: AtributosView,  name: 'atributos'  },
  { path: '/substatus',  component: SubstatusView,  name: 'substatus'  },
  { path: '/inventario', component: InventarioView, name: 'inventario' },
  { path: '/status',     component: StatusView,     name: 'status'     }
]

export default createRouter({
  history: createWebHistory(),
  routes
})