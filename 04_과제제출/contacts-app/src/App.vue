<template>
	<div id="app">
		<router-view></router-view>
	</div>
</template>

<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<style scoped>
#app {
	margin: 0;
	padding: 10px;
}
</style>
