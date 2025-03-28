<template>
    <div>
        X : <input type="text" v-model.number="state.x" /> <br />
        Y : <input type="text" v-model.number="state.y" /> <br />
        <div>결과 : {{ result }}</div>
    </div>
</template>

<script>
import { reactive, computed } from 'vue';
export default {
    name: 'Calc4',
    setup() {
        const state = reactive({ x: 10, y: 20 });

        // x와 y 둘 중 하나만 변경되면 result값 갱신
        const result = computed(() => {
            return state.x + state.y;
        });
        return { state, result };
    },
};
</script>
