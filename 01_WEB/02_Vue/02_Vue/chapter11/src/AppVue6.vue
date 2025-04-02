<template>
  <div>test</div>
</template>

<script setup>
import axios from "axios";

const requestApi = async () => {
  // 접근할 수 없는 경로기 때문에 404 에러 발생.
  const url = "/api/todos2";
  axios
    .get(url, { timeout: 900 })
    .then((result) => {
      console.log("result : ", result);
    })
    .catch((e) => {
      console.log("e : ", e);
    });
};

requestApi();
</script>

<style scoped></style>
