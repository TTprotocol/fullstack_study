<template>
    <Header>
        <img
            alt="Vue logo"
            class="logo"
            src="@/assets/logo.svg"
            width="100%"
            height="200px"
        />

        <div>
            <ul class="nav">
                <li class="nav-item">
                    <RouterLink to="/" class="nav-link">
                        <p><i class="fa-solid fa-house"></i> home</p>
                    </RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink to="/electronics" class="nav-link">
                        <p><i class="fa-solid fa-tv"></i> electronics</p>
                    </RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink to="/jewelery" class="nav-link">
                        <p><i class="fa-solid fa-gem"></i> jewelery</p>
                    </RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink to="/mensclothing" class="nav-link">
                        <p>mensclothing</p>
                    </RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink to="/womenclothing" class="nav-link">
                        <p>womenclothing</p>
                    </RouterLink>
                </li>
            </ul>
        </div>
    </Header>

    <!-- 라우터 페이지를 보여주는 곳. -->
    <RouterView />
</template>

<script>
import Header from './components/Header.vue';
import { RouterLink, RouterView } from 'vue-router';
import 'bootstrap/dist/css/bootstrap.css';

export default {
    name: 'App',
    setup() {},
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.0/css/all.min.css');
.nav {
    background-color: blue;
}
p {
    height: 5px;
    color: white;
    text-align: center;
}
</style>
