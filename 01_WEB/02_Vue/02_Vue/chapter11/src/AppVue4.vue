<template>
  <div>test</div>
</template>

<script setup>
import axios from "axios";

// post : 데이터를 생성할 때 사용.
// url/data/config 설정 가능
const requestApi = async () => {
  const url = "/api/todos";
  let data = {
    todo: "윗몸일으키기 3세트",
    desc: "너무 빠르지 않게",
  };

  const response = await axios.post(url, data);
  console.log("# 응답객체 : ", response);
};

requestApi();
</script>

<style scoped></style>
