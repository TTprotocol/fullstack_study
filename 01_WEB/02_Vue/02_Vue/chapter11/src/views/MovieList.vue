<template>
  <div>
    list test
    <ul>
      <li v-for="i in data" :key="i.id">{{ i.title }} - {{ i.director }}</li>
    </ul>
  </div>
</template>

<script setup>
import { inject } from "vue";

console.log("list test : ");

const data = inject("movie");
console.log("data : ", data);
</script>

<style lang="scss" scoped></style>
