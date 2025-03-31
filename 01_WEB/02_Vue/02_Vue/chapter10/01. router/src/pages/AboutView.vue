<template>
    <div class="card card-body">
        <h2>About</h2>
        <!-- 현재 라우트 객체의 전체 경로 -->
        <p>요청 경로 : {{ $route.fullPath }}</p>
    </div>
</template>

<script>
export default {
    name: 'About',
    created() {
        // 옵션 APU 버전으로 $route는 현재
        console.log(this.$route);
    },
};
</script>
<style>
@media (min-width: 1024px) {
    .about {
        min-height: 100vh;
        display: flex;
        align-items: center;
    }
}
</style>
