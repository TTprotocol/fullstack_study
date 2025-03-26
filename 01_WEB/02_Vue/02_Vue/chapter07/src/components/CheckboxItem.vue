<template>
    <li><input type="checkbox" :checked="checked" />{{ name }}</li>
</template>

<script>
export default {
    name: 'CheckboxItem', // 임의 이름
    props: ['name', 'checked'],
};
</script>
