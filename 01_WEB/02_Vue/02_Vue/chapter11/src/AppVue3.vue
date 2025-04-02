<template>
  <div>test</div>
</template>

<script setup>
import axios from "axios";

// get은 데이터를 가져올 때 사용한다.
// url과 config 설정 가능.
const requestApi = async () => {
  const url = "/api/todos";

  const response = await axios.get(url);
  console.log("# 응답객체 : ", response);
};

requestApi();
</script>

<style scoped></style>
