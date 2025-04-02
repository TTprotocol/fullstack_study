<template>
  <div>
    <router-view name="list"></router-view>
  </div>
</template>

<script setup>
import { provide, ref, onMounted } from "vue";
import axios from "axios";

const movies = ref([]);
async function fetchMovies() {
  try {
    const response = await axios.get("http://localhost:3000/movies");
    movies.value = response.data;
  } catch (error) {
    console.error("영화 데이터를 불러오는 중 오류 발생:", error);
  }
}

onMounted(fetchMovies);
provide("movies", movies);
</script>

<style scoped></style>
