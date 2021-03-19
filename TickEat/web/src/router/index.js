import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Registo from '../views/Consumidor/Registo.vue'
import DefinirPassword from '../views/DefinirPassword.vue'
import Calendario from '../views/Consumidor/Calendario.vue'
import Pedido from '../views/Administrador/PedidosConta.vue'
import Refeicao from '../views/Consumidor/Refeicao.vue'
import Reservar from '../views/Consumidor/Reservar.vue'
import Avaliar from '../views/Consumidor/Avaliar.vue'
import EditarRefeicao from '../views/Consumidor/EditarRefeicao.vue'
import Saldo from '../views/Consumidor/Saldo.vue'
import Carregamento from '../views/Consumidor/Carregamento.vue'
import Carregar from '../views/Consumidor/Carregar.vue'
import Perfil from '../views/Consumidor/Perfil.vue'
import EditarPerfil from '../views/Consumidor/EditarPerfil.vue'
import Inicio from '../views/Consumidor/Inicio.vue'
import InicioCoz from '../views/Cozinheiro/Inicio.vue'
import Cantinas from '../views/Administrador/Cantinas.vue'
import AdicionarCantina from '../views/Administrador/AdicionarCantina.vue'
import AnaliseDiaria from '../views/Administrador/AnaliseDiaria.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: Login
  },
  {
    path: '/registo',
    name: 'registo',
    component: Registo
  },
  {
    path: '/password',
    name: 'password',
    component: DefinirPassword
  },
  {
    path: '/calendario',
    name: 'calendario',
    component: Calendario
  },
  {
    path: '/pedidos',
    name: 'pedidos',
    component: Pedido
  },
  {
    path: '/refeicao',
    name: 'refeicao',
    component: Refeicao
  },
  {
    path: '/reservar',
    name: 'reservar',
    component: Reservar
  },
  {
    path: '/avaliar',
    name: 'avaliar',
    component: Avaliar
  },
  {
    path: '/editarRefeicao',
    name: 'editarRefeicao',
    component: EditarRefeicao
  },
  {
    path: '/saldo',
    name: 'saldo',
    component: Saldo
  },
  {
    path: '/carregamento',
    name: 'carregamento',
    component: Carregamento
  },
  {
    path: '/carregar',
    name: 'carregar',
    component: Carregar
  },
  {
    path: '/perfil',
    name: 'perfil',
    component: Perfil
  },
  {
    path: '/editarPerfil',
    name: 'editarPerfil',
    component: EditarPerfil
  },
  {
    path: '/inicio',
    name: 'inicio',
    component: Inicio
  },
  {
    path: '/inicioCoz',
    name: 'inicioCoz',
    component: InicioCoz
  },
  {
    path: '/cantinas',
    name: 'cantinas',
    component: Cantinas
  },
  {
    path: '/adicionarCantina',
    name: 'adicionarCantina',
    component: AdicionarCantina
  },
  {
    path: '/analisediaria',
    name: 'analisediaria',
    component: AnaliseDiaria
  }/*,
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/About.vue')
  }*/
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
