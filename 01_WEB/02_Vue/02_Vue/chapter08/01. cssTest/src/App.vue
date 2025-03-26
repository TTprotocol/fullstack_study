<template>
    <Child1 />
    <Child2 />
    <Child3 />
</template>

<script>
// 가장 마지막에 import한 색상으로 스타일이 적용된다.
import Child1 from './components/Child1.vue';
import Child2 from './components/Child2.vue';
import Child3 from './components/Child3.vue';
export default {
    name: 'App',
    components: {
        // 전역, 지역, 모듈 css 확인
        // 스타일 테스트
        Child1,
        Child2,
        Child3,
    },
    methods: {
        changeTab(tab) {
            this.currentTab = tab;
        },
        mission1Click(message) {
            console.log(message);
        },
    },
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/fontawesome/5.14.0/css/all.min.css');
h1 {
    text-align: center;
}
.header {
    padding: 20px 0px 0px 20px;
}
.headerText {
    padding: 0px 20px 40px 20px;
}
.tab {
    padding: 30px;
}
</style>
