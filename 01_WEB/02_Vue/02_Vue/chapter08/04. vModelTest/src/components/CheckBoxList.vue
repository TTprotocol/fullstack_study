<template>
    <!-- items는 부모에게서 받아온 props -->
    <div v-for="item in items" :key="item.id">
        <!-- checked 값을 객체로 묶어서 slot에 전달. -->
        <slot name="icon" :checked="item.checked"></slot>
        <input
            type="checkbox"
            :value="item.id"
            :checked="item.checked"
            @change="
                $emit('check-changed', {
                    id: item.id,
                    checked: $event.target.checked,
                })
            "
        />
        <!-- checked와 label의 값을 객체로 묶어서 slot에 전달. -->
        <slot :checked="item.checked" :label="item.label"></slot>
    </div>
</template>
<script>
export default {
    name: 'CheckBoxList',
    props: ['items'],
};
</script>
