<template>
    <div>
        x : <input type="text" v-model.number="state.x" /> <br />
        결과 : {{ state.result }}
    </div>
</template>

<script>
import { reactive, watch } from 'vue';
export default {
    name: 'Calc6',
    setup() {
        const state = reactive({ x: 0, result: 0 });

        // 기본형 데이터는 watch에 직접 넣으면 반응형 동작이 안된다.
        // 무조건 getter 함수를 통해서 추적해야 한다.
        watch(
            () => state.x,
            (current, old) => {
                console.log(`${old} -> ${current}`);
                state.result = current * 2;
            }
        );
        return { state };
    },
};
</script>
