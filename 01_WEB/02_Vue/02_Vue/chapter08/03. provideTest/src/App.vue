<template>
    <div>
        <h2>최신 인기곡</h2>
        <SongList :songs="songs" />
    </div>
    <br /><br />
    <button @click="changeModal">Teleport를 이용한 Modal 기능</button>
    <!-- id가 modal인 영역을 찾아서 isModal 값에 의해 보여주기 -->
    <teleport to="#modal"> <Modal v-if="isModal" /> </teleport>
</template>

<script>
// provider / injection
import { computed } from 'vue';
import SongList from './components/SongList.vue';
// teleport로 모달 창 띄우기
import Modal from './components/Modal.vue';

export default {
    name: 'App',
    components: {
        // provider / inject 테스트
        SongList,

        // 모달 창 띄우기
        Modal,
    },
    data() {
        return {
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
        changeModal() {
            // 잠시 보여줬다가 2초 후 모달 사라지기
            this.isModal = true;
            setTimeout(() => {
                this.isModal = false;
            }, 2000);
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
</style>
