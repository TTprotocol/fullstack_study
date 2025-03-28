<template>
    <div>
        X : <input type="text" v-model.number="x" /><br />
        Y : <input type="text" v-model.number="y" /><br />
    </div>
</template>
<script>
import { ref } from 'vue';
export default {
    name: 'Calc',
    setup() {
        // 기본형 데이터는 반응성을 띄기 위해 ref로 감싸준다.
        const x = ref(10);
        const y = ref(20);
        // 템플리셍서 사용하기 위해 값을 리턴해준다.
        return { x, y };
    },
};
</script>
