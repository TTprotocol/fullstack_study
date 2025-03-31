import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/pages/HomeView.vue';
import AboutView from '@/pages/AboutView.vue';
import MembersView from '@/pages/MembersView.vue';
import MemberInfo from '@/pages/MemberInfo.vue';
import VideoView from '@/pages/VideoView.vue';
import VideoPlayer from '@/pages/VideoPlayer.vue';

const router = createRouter({
    history: createWebHistory(), // 히스토리 모드 설정
    routes: [
        // 해당 path로 접근 시 해당 컴포넌트 렌더링
        {
            path: '/',
            name: 'home',
            component: HomeView,
        },
        {
            path: '/about',
            name: 'about',
            // route level code-splitting
            // this generates a separate chunk (About.[hash].js) for this route
            // which is lazy-loaded when the route is visited.
            component: AboutView,
        },
        {
            path: '/members',
            name: 'members',
            component: MembersView,
        },
        // 경로에 :이 붙으면 동적 파라미터 할당 가능
        {
            path: '/members/:id',
            name: 'members/id',
            component: MemberInfo,
        },
        {
            path: '/videos',
            name: 'videos',
            component: VideoView,
            // 하나의 라우트 내에서 또다른 라우트를 띄우는 중첩 라우트 구조
            children: [
                {
                    path: ':id',
                    name: 'videos/id',
                    component: VideoPlayer,
                },
            ],
        },
    ],
});

export default router;
