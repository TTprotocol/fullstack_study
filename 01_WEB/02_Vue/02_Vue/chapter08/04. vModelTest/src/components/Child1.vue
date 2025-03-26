<template>
    <div class="child">
        <h2>Child1</h2>
    </div>
</template>

<script>
export default {
    name: 'Child1',
};
</script>

<!-- scoped를 붙이면 해당 컴포넌트 내에서만 스타일 적용 -->
<style scoped>
.child {
    background-color: yellow;
    border: 1px solid black;
    margin: 1.5em;
    padding: 1em;
}
</style>
