import { createRouter, createWebHistory } from 'vue-router'
import NotFound from '../views/error/NotFound';
import PkIndexView from '../views/pk/PkIndexView';
import RanklistIndexView from '../views/ranklist/RanklistIndexView';
import RecordlistIndexView from '../views/record/RecordlistIndexView';
import UserBotIndexView from '../views/user/bot/UserBotIndexView';

const routes = [
  {
    path: '/',
    name: 'home',
    redirect: '/pk/'
  },
  {
    path: '/404/',
    name: '404',
    component: NotFound,
  },
  {
    path: '/pk/',
    name: 'pk_index',
    component: PkIndexView,
  },
  {
    path: '/record/',
    name: 'record_index',
    component: RecordlistIndexView,
  },
  {
    path: '/rank/',
    name: 'ranklist_index',
    component: RanklistIndexView,
  },
  {
    path: '/user/bot/',
    name: 'user_bot_index',
    component: UserBotIndexView,
  },
  {
    path: '/:catchAll(.*)',
    redirect: '/404/'
  },

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
