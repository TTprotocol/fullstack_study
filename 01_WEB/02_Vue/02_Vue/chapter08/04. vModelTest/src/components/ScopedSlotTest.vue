<template>
    <div>
        <h3>당신이 경험한 프론트 엔드 기술은?(네번째:ScopedSlot)</h3>
        <CheckBoxList :items="items" @check-changed="CheckBoxChanged">
            <!-- p1이라는 객체 이름은 슬롯 내부에서만 이용 하등. -->
            <template v-slot:icon="p1">
                <i v-if="p1.checked" class="far fa-grin-beam"></i>
                <i v-else class="far fa-frown"></i>
            </template>
            <!-- 체크 여부에 따라 span을 변경하는 슬롯 -->

            <template v-slot:default="p2">
                <span
                    v-if="p2.checked"
                    style="color: blue; text-decoration: underline"
                >
                    <i>{{ p2.label }}</i>
                </span>
                <span v-else style="color: gray">{{ p2.label }}</span>
            </template>
        </CheckBoxList>
    </div>
</template>

<script>
import CheckBoxList from './CheckBoxList.vue';
export default {
    name: 'ScopedSlotTest',
    components: { CheckBoxList },
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
            let item = this.items.find((item) => item.id === e.id);
            item.checked = e.checked;
        },
    },
};
</script>
<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css');
</style>
