<template>
    <div :class="$style.child">
        <h2>Child3</h2>
    </div>
</template>

<script>
export default {
    name: 'Child3',
    created() {
        console.log(this.$style);
    },
};
</script>

<style module>
.child {
    background-color: orange;
    border: 1px solid black;
    margin: 1.5em;
    padding: 1em;
}
</style>
