import { ref, computed } from 'vue';
import { defineStore } from 'pinia';

// 샘플 스토어
export const useCounterStore = defineStore('counter', () => {
    const count = ref(0);
    const doubleCount = computed(() => count.value * 2);

    function increment() {
        count.value++;
    }

    return { count, doubleCount, increment };
    // count가 직접적으로 내보내 졌기 때문에, 다른 컴포넌트에서 count를 직접 수정할 수 있게 된다.
});
