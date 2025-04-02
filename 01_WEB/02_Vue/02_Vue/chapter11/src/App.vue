<template>
  <div>test</div>
</template>

<script setup>
// import { provide } from "vue";
import axios from "axios";

// const data = async () => {
//   return await axios.get("http://localhost:3000/move");
// };

// provide("movie", data);

const listUrl = "api/todos"; // 전체 목록
const todoUrlPrefix = "api/todos/"; // 상세페이지

const requestApi = () => {
  // const url = "http://localhost:3000/todos/1";
  // 해당 url로 get 메서드 날린 후 응답 확인
  // const url = "api/todos/1";
  // axios.get(url).then((result) => {
  //   console.log("result : ", result);
  // });

  // 전체 todoList 목록 출력
  let todoList = [];
  axios
    .get(listUrl)
    .then((result) => {
      todoList = result.data;
      console.log("todoList : ", todoList);
      return todoList[0].id;
    })
    .then((id) => {
      // 첫 번째 todo 가져오기
      return axios.get(todoUrlPrefix + id);
    })
    .then((result) => {
      // 가져온 첫 번째 todo 출력
      console.log("## 첫 번째 Todo : ", result.data);
      // 두 번째 todo 리턴
      return todoList[1].id;
    })
    .then((id) => {
      // 두 번째 todo 가져와서 출력
      return axios.get(todoUrlPrefix + id).then((result) => {
        console.log("## 두 번째 todo : ", result.data);
      });
    });
};

requestApi();
</script>

<style scoped></style>
