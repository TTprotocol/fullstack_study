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

    <!-- 자식에서 변경될 때 마다 name 값이 searchName에 반영됨 -->
    <!-- <div>
        <InputName v-model:name="searchName" />
        <h3>검색어 : {{ searchName }}</h3>
    </div> -->

    <div>
        <h2>최신 인기곡</h2>
        <SongList :songs="songs" />
    </div>
    <br /><br />
    <button @click="changeModal">Teleport를 이용한 Modal 기능</button>
    <!-- id가 modal인 영역을 찾아서 isModal 값에 의해 보여주기 -->
    <teleport to="#modal"> <Modal v-if="isModal" /> </teleport>

    <!-- mission -->
    <h1>Improv Acting Lab</h1>
    <Mission1 @ready="mission1Click">
        오늘도 넌 멋질 거야! 🎤 자신 있게 무대에 올라가!
    </Mission1>
</template>

<script>
// 가장 마지막에 import한 색상으로 스타일이 적용된다.
import Child1 from './components/Child1.vue';
import Child2 from './components/Child2.vue';
import Child3 from './components/Child3.vue';
// slot 테스트
import NoSlotTest from './components/NoSlotTest.vue';
import SlotTest from './components/SlotTest.vue';
import NamedSlotTest from './components/NamedSlotTest.vue';
import ScopedSlotTest from './components/ScopedSlotTest.vue';
//
import CoralSeaTab from './components/CoralSeaTab.vue';
import LeyteGulfTab from './components/LeyteGulfTab.vue';
import MidwayTab from './components/MidwayTab.vue';
// 컴포넌트 v-model
import InputName from './components/InputName.vue';
// provider / injection
import { computed } from 'vue';
import SongList from './components/SongList.vue';
// teleport로 모달 창 띄우기
import Modal from './components/Modal.vue';

// mission
import Mission1 from './components/mission1_LineReadyButton.vue';

export default {
    name: 'App',
    components: {
        // 전역, 지역, 모듈 css 확인
        // 스타일 테스트
        Child1,
        Child2,
        Child3,

        // slot 테스트
        NoSlotTest,
        SlotTest,
        NamedSlotTest,
        ScopedSlotTest,

        //
        CoralSeaTab,
        LeyteGulfTab,
        MidwayTab,

        // 컴포넌트에서의 v-model 테스트
        InputName,

        // provider / inject 테스트
        SongList,

        // 모달 창 띄우기
        Modal,

        // mission
        Mission1,
    },
    data() {
        return {
            currentTab: 'CoralSeaTab',
            tabs: [
                { id: 'CoralSeaTab', label: '산호해 해전' },
                { id: 'MidwayTab', label: '미드웨이 해전' },
                { id: 'LeyteGulfTab', label: '레이테만 해전' },
            ],
            //
            searchName: 'John',
            //
            songs: [
                { id: 1, title: 'Blueming', done: true },
                { id: 2, title: 'Dynamite', done: true },
                { id: 3, title: 'Lovesick Girls', done: false },
                { id: 4, title: '마리아(Maria)', done: false },
            ],
            isModal: false,
        };
    },
    methods: {
        changeTab(tab) {
            this.currentTab = tab;
        },

        changeModal() {
            // 잠시 보여줬다가 2초 후 모달 사라지기
            this.isModal = true;
            setTimeout(() => {
                this.isModal = false;
            }, 2000);
        },

        mission1Click(message) {
            console.log(message);
        },
    },
    // provide : 하위 요소 어디든 주입받을 수 있도록 상위요소에서 제공
    provide() {
        return {
            icons: {
                checked: 'far fa-check-circle',
                unchecked: 'far fa-circle',
            },
            doneCount: computed(() => {
                return this.songs.filter((s) => s.done === true).length;
            }),
        };
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
