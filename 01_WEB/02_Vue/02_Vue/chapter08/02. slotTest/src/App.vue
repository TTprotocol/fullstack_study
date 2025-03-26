<template>
    <div>
        <NoSlotTest />
        <SlotTest />
        <NamedSlotTest />
        <ScopedSlotTest />
    </div>
</template>

<script>
// slot 테스트
import NoSlotTest from './components/NoSlotTest.vue';
import SlotTest from './components/SlotTest.vue';
import NamedSlotTest from './components/NamedSlotTest.vue';
import ScopedSlotTest from './components/ScopedSlotTest.vue';

export default {
    name: 'App',
    components: {
        // slot 테스트
        NoSlotTest,
        SlotTest,
        NamedSlotTest,
        ScopedSlotTest,
    },
    methods: {
        changeTab(tab) {
            this.currentTab = tab;
        },
    },
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/fontawesome/5.14.0/css/all.min.css');
</style>
