<template>
    <div class="card mt-4 p-3 d-flex align-self-center text-center">
        <div v-if="currentLine.line === ''">
            <h2>아직 대사가 없습니다. 버튼을 눌러주세요!</h2>
        </div>
        <div v-else>
            <h2>{{ currentLine.line }}</h2>
            <p>{{ currentLine.source }}</p>
        </div>

        <button @click="click" class="btn btn-primary mb-3">
            랜덤 대사 뽑기
        </button>
        <p>오늘의 즉흥 대사입니다!</p>
        <div class="card card-body p-3">
            <slot name="tip"></slot>
        </div>
        <div class="card card-img-top p-3">
            <slot name="image"></slot>
        </div>
    </div>
</template>

<style></style>

<script>
export default {
    name: 'mission2',
    emits: ['ready'],
    inject: ['lines'],
    data() {
        return { currentLine: { line: 'test', source: 'test' } };
    },
    methods: {
        click() {
            let count = Math.floor(Math.random() * this.lines.length);

            this.currentLine = this.lines[count];
        },
    },
};
</script>

<style></style>
