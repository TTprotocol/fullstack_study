<template>
    <div class="text-center mt-3">
        <button class="btn btn-danger rounded-pill px-4 py-2" @click="click">
            준비되면 눌러주세요! 자신감을 가져요!
        </button>
        <p class="mt-2">버튼을 누른 횟수 : {{ count }}회</p>
        <div class="slot-box">
            <slot>여기에 서윤이의 코멘트가 들어갑니다.</slot>
        </div>
    </div>
</template>

<style></style>

<script>
export default {
    name: 'mission2',
    emits: ['ready'],
    data() {
        return { count: 0 };
    },
    methods: {
        click() {
            this.count++;
            this.$emit('ready', `대사 준비 완료! (총 ${this.count}회 눌림)`);
        },
    },
};
</script>

<style>
.btn {
    background-color: #ff7675;
    border-radius: 12px;
    text-align: center;
}
.btn:hover {
    background-color: #d63031;
}
#slot-box {
    margin: 10px;
    background-color: #f1f2f6;
    border: 1px solid #dfe4ea;
    border-radius: 14px;
    padding: 14px;
    max-width: 400px;
}
</style>
