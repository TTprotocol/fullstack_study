import { createRouter, createWebHistory } from 'vue-router'
import StudyList from '@/pages/StudyList.vue'
import StudyItem from '@/components/StudyItem.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/studies',
      name: 'studies',
      component: StudyList,
    },
    {
      path: '/studies/:id',
      name: 'studies/id',
      component: StudyItem,
    },
  ],
})

export default router
