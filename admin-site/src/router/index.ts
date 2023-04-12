// Composables
import { createApp } from "vue";
import { createRouter, createWebHistory } from 'vue-router'
import App from "./App.vue";
import AdminPortal from "./AdminPortal.vue";

//const app = createApp(App);

//app.mount("#app");


const routes = [
  {
    path: '/',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '',
        name: 'Home',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "home" */ '@/views/AdminLoginPage.vue'),

      },
      {
        path: '/AdminPortal',
        name: 'AdminPortal',
        component: () => import('@/views/AdminPortal.vue'),
      },
    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
