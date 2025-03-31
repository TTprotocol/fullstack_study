<template>
    <Header>
        <img
            alt="Vue logo"
            class="logo"
            src="@/assets/logo.svg"
            width="125"
            height="125"
        />

        <div class="wrapper">
            <nav>
                <RouterLink to="/">Home</RouterLink>
                <RouterLink to="/about">About</RouterLink>
                <RouterLink to="/members">Member</RouterLink>
                <RouterLink to="/video">Video</RouterLink>
            </nav>
        </div>
    </Header>

    <!-- 라우터 페이지를 보여주는 곳. -->
    <!-- 경로에 따라 다른 컴포넌트가 렌더링된다. -->
    <RouterView />
</template>

<script setup>
import Header from './components/Header.vue';
import { RouterLink, RouterView } from 'vue-router';
import videos from '@/videos.json';
import { provide } from 'vue';

// 하위 컴포넌트에서 videos 배열 모두 사용할 수 있도록
provide('videos', videos);
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.0/css/all.min.css');
.container {
    text-align: center;
    margin-top: 10px;
}
</style>
