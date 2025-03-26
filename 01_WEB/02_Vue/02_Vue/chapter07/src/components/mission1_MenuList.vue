<template>
    <div id="menuList">
        <button
            v-for="(menu, index) in menuList"
            :key="index"
            value="menu.name"
            @click="$emit('select-drink', menu)"
        >
            {{ menu.name }} ({{ menu.price }}원)
        </button>
    </div>
</template>

<style>
#menuList {
    display: flex;
    justify-content: space-around;
    margin-bottom: 15px;
}
button {
    margin: 5px;
    padding: 10px;
    cursor: pointer;
}
</style>

<script>
export default {
    name: 'MenuList',
    props: ['menuList'],
    emits: ['select-drink'],
};
</script>
