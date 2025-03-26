<template>
    <div>
        <h3>당신이 경험한 프론트 엔드 기술은?(두번째:slot기본)</h3>
        <!-- slot을 사용하면 부모의 데이터에 접근하기가 쉽다 -->
        <CheckBox2
            v-for="item in items"
            :key="item.id"
            :id="item.id"
            :checked="item.checked"
            @check-changed="CheckBoxChanged"
        >
            <span
                v-if="item.checked"
                style="color: blue; text-decoration: underline"
            >
                <i>{{ item.label }}</i>
            </span>
            <span v-else style="color: gray">{{ item.label }}</span>
        </CheckBox2>
    </div>
</template>

<script>
import CheckBox2 from './CheckBox2.vue';
export default {
    name: 'SlotTest',
    components: { CheckBox2 },
    data() {
        return {
            items: [
                { id: 'V', checked: true, label: 'Vue' },
                { id: 'A', checked: false, label: 'Angular' },
                { id: 'R', checked: false, label: 'React' },
                { id: 'S', checked: false, label: 'Svelte' },
            ],
        };
    },
    methods: {
        CheckBoxChanged(e) {
            // 받아온 객체의 id를 items 배열에서 찾아서 일치하는 객체 반환
            let item = this.items.find((item) => item.id === e.id);
            // 찾은 객체의 checked를 받아온 값으로 변경
            item.checked = e.checked;
        },
    },
};
</script>
