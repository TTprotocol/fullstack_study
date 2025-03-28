<template>
    <div>
        <h1>Improv Acting Lab</h1>
        <Mission1 @ready="mission1Click">
            오늘도 넌 멋질 거야! 🎤 자신 있게 무대에 올라가!
        </Mission1>
        <Mission2 v-if="message !== ''">
            <template #tip>test</template>
            <template #image>test</template>
        </Mission2>
    </div>
</template>

<script>
import Mission1 from './components/mission1_LineReadyButton.vue';
import Mission2 from './components/mission2_LineCard.vue';

export default {
    name: 'App',
    components: {
        Mission1,
        Mission2,
    },
    data() {
        return {
            message: '',
        };
    },
    methods: {
        mission1Click(message) {
            console.log(message);
            this.message = message;
        },
    },
    provide() {
        return {
            lines: [
                {
                    line: '조금은 친절해도 되잖아. 다들 니들처럼 익숙한 게 아니니까.',
                    source: '청춘시대',
                },
                {
                    line: '너와 함께한 시간 모두 눈부셨다. 날이 좋아서 날이 좋지 않아서 날이 적당해서 모든 날이 좋았다.',
                    source: '도깨비',
                },
                {
                    line: '당신이 좋은 이유? 그저 그 사람이라서. 바로 너라서.',
                    source: '응답하라 1997',
                },
                {
                    line: '인생에서 시련 오는 거, 진짜와 가짜를 한 번씩 걸러내라고 하나님이 주신 기회가 아닌가 싶다.',
                    source: '별에서 온 그대',
                },
                {
                    line: '잊지 말자. 나는 어머니의 자부심이다. 모자라고 부족한 자식이 아니다.',
                    source: '미생',
                },
            ],
        };
    },
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/fontawesome/5.14.0/css/all.min.css');
h1 {
    text-align: center;
}
</style>
