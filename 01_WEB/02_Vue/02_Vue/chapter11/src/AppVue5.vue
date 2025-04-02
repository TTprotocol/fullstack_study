<template>
  <div>test</div>
</template>

<script setup>
import axios from "axios";

const requestApi = async () => {
  const url = "/api/todos";

  try {
    const response = await axios.post(url, { timeout: 900 });
    console.log("# 응답객체 : ", response);
  } catch (e) {
    // 에러가 있는 경우 해당 에러의 메시지 출력
    console.log("## 다음 오류 발생 : ");
    if (e instanceof Error) {
      console.log(e.message);
    } else console.log(e);
  }
};

requestApi();
</script>

<style scoped></style>
