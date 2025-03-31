<template>
    <nav class="navbar navbar-expand-md bg-dark navbar-dark mt-2">
        <span class="navbar-brand">이날치(LeeNalChi)</span>
        <!-- 햄버거 아이콘 클릭시 동작 -->
        <button class="navbar-toggler" type="button" @click="changeIsNavShow">
            <!-- 햄버거 아이콘 -->
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- 화면 넓을 때 메뉴 탭. 계산된 속성으로 바인딩 되어 있다. -->
        <div :class="navClass">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <!-- router-link는 a 태그처럼 동작, to 경로로 이동 -->
                    <!-- router/index.js에 명시된 to 경로와 연결된 컴포넌트로 이동 -->
                    <!-- name으로 명명된 라우트를 연결하려면 객체로 바인딩해야한다. -->
                    <router-link class="nav-link" :to="{ name: 'home' }">
                        홈
                    </router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" :to="{ name: 'about' }">
                        소개
                    </router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" :to="{ name: 'members' }">
                        멤버
                    </router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" :to="{ name: 'videos' }">
                        영상
                    </router-link>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
import { reactive, computed } from 'vue';

export default {
    setup() {
        const state = reactive({ isNavShow: false });

        // isNavShow의 값에 따라서 각각 다른 클래스가 바인딩된다.
        const navClass = computed(() =>
            state.isNavShow
                ? 'collapse navbar-collapse show'
                : 'collapse navbar-collapse'
        );

        const changeIsNavShow = () => {
            // isNavShow의 값을 반대로 변경
            state.isNavShow = !state.isNavShow;
        };

        return { state, changeIsNavShow, navClass };
    },
};
</script>

<style></style>
