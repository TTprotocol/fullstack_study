<template>
  <div>test</div>
</template>

<script setup>
import axios from "axios";

const listUrl = "api/todos"; // 전체 목록
const todoUrlPrefix = "api/todos/"; // 상세페이지

const requestApi = async () => {
  let todoList = [];

  // 보통 axios 처리할 때 서버에서 받아오기 위해 await를 쓴다.
  let response = await axios.get(listUrl);
  todoList = response.data;

  console.log("# TodoList : ", todoList);
  // 리스트의 개별 요소들을 돌면서 하나씩 출력
  for (let i = 0; i < todoList.length; i++) {
    response = await axios.get(todoUrlPrefix + todoList[i].id);
    console.log(`${i}번째 todo : ${response.data}`);
  }
};

requestApi();
</script>

<style scoped></style>
