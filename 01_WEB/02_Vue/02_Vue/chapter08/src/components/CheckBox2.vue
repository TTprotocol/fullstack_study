<template>
    <div>
        <input
            type="checkbox"
            :value="id"
            :checked="checked"
            @change="
                $emit('check-changed', { id, checked: $event.target.checked })
            "
        />
        <!-- 부모가 넘겨준 templete이 없다면 기본 텍스트인 Item이 출력 -->
        <slot>Item</slot>
    </div>
</template>
<script>
export default {
    name: 'CheckBox2',
    props: ['id', 'checked'],
};
</script>
