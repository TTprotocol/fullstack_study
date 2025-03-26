<template>
    <!-- <Child1 />
    <Child2 />
    <Child3 /> -->

    <!-- <div>
        <NoSlotTest />
        <SlotTest />
        <NamedSlotTest />
        <ScopedSlotTest />
    </div> -->

    <!-- <div class="header">
        <h1 class="headerText">태평양 전쟁의 해전</h1>
        <nav>
            <ul class="nav nav-tabs nav-fill">
                <li v-for="tab in tabs" :key="tab.id" class="nav-item">
                    <a
                        style="cursor: pointer"
                        class="nav-link"
                        :class="{ active: tab.id === currentTab }"
                        @click="changeTab(tab.id)"
                        >{{ tab.label }}</a
                    >
                </li>
            </ul>
        </nav>
    </div>
    <div class="container">
        <keep-alive include="MidwayTab,CoralSeaTab">
            <component :is="currentTab"></component>
        </keep-alive>
    </div> -->

    <div>
        <InputName v-model:name="searchName" } />
        <h3>검색어 : {{ searchName }}</h3>
    </div>
</template>

<script>
import Child1 from './components/Child1.vue';
import Child2 from './components/Child2.vue';
import Child3 from './components/Child3.vue';
//
import NoSlotTest from './components/NoSlotTest.vue';
import SlotTest from './components/SlotTest.vue';
import NamedSlotTest from './components/NamedSlotTest.vue';
import ScopedSlotTest from './components/ScopedSlotTest.vue';
//
import CoralSeaTab from './components/CoralSeaTab.vue';
import LeyteGulfTab from './components/LeyteGulfTab.vue';
import MidwayTab from './components/MidwayTab.vue';
//
import InputName from './components/InputName.vue';

export default {
    name: 'App',
    components: {
        Child1,
        Child2,
        Child3,
        //
        NoSlotTest,
        SlotTest,
        NamedSlotTest,
        ScopedSlotTest,
        //
        CoralSeaTab,
        LeyteGulfTab,
        MidwayTab,
        //
        InputName,
    },
    data() {
        return {
            currentTab: 'CoralSeaTab',
            tabs: [
                { id: 'CoralSeaTab', label: '산호해 해전' },
                { id: 'MidwayTab', label: '미드웨이 해전' },
                { id: 'LeyteGulfTab', label: '레이테만 해전' },
            ],

            searchName: 'John',
        };
    },
    methods: {
        changeTab(tab) {
            this.currentTab = tab;
        },
    },
};
</script>

<style>
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
