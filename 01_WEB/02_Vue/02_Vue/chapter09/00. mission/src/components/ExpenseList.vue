<template>
    <h3 class="text-start mt-3">지출내역</h3>
    <ul>
        <li v-for="(item, index) in props.list" :key="index">
            <p class="card text-start-item p-24">
                <i class="fa-thin fa-mug-saucer"></i
                ><i class="fa-regular fa-mug-saucer"></i> {{ item.item }} :
                {{ item.price }}
            </p>
        </li>
    </ul>
</template>

<script setup>
import { ref, reactive, defineProps } from 'vue';

const props = defineProps({
    list: { type: Array, required: true },
});

console.log('porps : ', props.list);
</script>

<style>
.text-start {
    color: #3dffbc;
}

.text-start-item {
    color: white;
    background-color: gray;
    display: flex;
    justify-content: center;
}
</style>
